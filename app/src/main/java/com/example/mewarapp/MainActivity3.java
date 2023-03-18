package com.example.mewarapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity3 extends AppCompatActivity {
RecyclerView recyclerView;
TextView welTextView;
EditText messEditText;
ImageButton sendButton;
List<Message> messageList;
MessageAdaptor messageAdaptor;

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        messageList=new ArrayList<>();
        recyclerView =findViewById(R.id.recycler_view);
        welTextView=findViewById(R.id.welcome_text);
        messEditText=findViewById(R.id.message_edit_text);
        sendButton=findViewById(R.id.send_btn);

        messageAdaptor=new MessageAdaptor(messageList);
        recyclerView.setAdapter(messageAdaptor);
        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setStackFromEnd(true);
        recyclerView.setLayoutManager(llm);

        sendButton.setOnClickListener((v) -> {
            String question=messEditText.getText().toString().trim();
            addToChat(question,Message.SENT_BY_ME);
            messEditText.setText("");
            callAPI(question);
            welTextView.setVisibility(View.GONE);
        });
    }

    void addToChat(String message,String sentBy){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                messageList.add(new Message(message,sentBy));
                messageAdaptor.notifyDataSetChanged();
                recyclerView.smoothScrollToPosition(messageAdaptor.getItemCount());
            }
        });

    }
    void addResponse(String response){
        messageList.remove(messageList.size()-1);
        addToChat(response,Message.SENT_BY_BOT);

    }

    void callAPI(String question){
        messageList.add(new Message("Typing......",Message.SENT_BY_BOT));
        JSONObject jsonBody=new JSONObject();
        try {
            jsonBody.put("model","text-davinci-003");
            jsonBody.put("prompt",question);
            jsonBody.put("max_tokens",4000);
            jsonBody.put("temperature",0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body=RequestBody.create(jsonBody.toString(),JSON);
        Request request=new Request.Builder()
                .url("https://api.openai.com/v1/completions")
                .header("Authorization","Bearer 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")
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                addResponse("Failed To Load Response due to"+e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
             if (response.isSuccessful()){
                 JSONObject jsonObject= null;
                 try {
                     jsonObject = new JSONObject(response.body().string());
                     JSONArray jsonArray= jsonObject.getJSONArray("choices");
                     String result=jsonArray.getJSONObject(0).getString("text");
                     addResponse(result.trim());
                 } catch (JSONException e) {
                     e.printStackTrace();
                 }

             }else{
                 addResponse("Failed To Load Response due to"+response.body().toString());
             }
            }
        });
    }
}