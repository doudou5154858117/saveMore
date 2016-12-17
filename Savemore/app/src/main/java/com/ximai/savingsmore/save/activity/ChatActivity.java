package com.ximai.savingsmore.save.activity;

import android.os.Bundle;

import com.easemob.easeui.EaseConstant;
import com.ximai.savingsmore.R;
import com.ximai.savingsmore.library.net.MyAsyncHttpResponseHandler;
import com.ximai.savingsmore.library.net.RequestParamsPool;
import com.ximai.savingsmore.library.net.URLText;
import com.ximai.savingsmore.library.net.WebRequestHelper;
import com.ximai.savingsmore.save.common.BaseActivity;

import org.apache.http.Header;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caojian on 16/12/16.
 */
public class ChatActivity extends BaseActivity {
    private String UserName;
    List<String> listName=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_activity);
        setLeftBackMenuVisibility(ChatActivity.this, "");
        UserName = getIntent().getStringExtra(EaseConstant.EXTRA_USER_ID);
        listName.add(UserName);
        getUserByIM(listName);
    }

    private void getUserByIM(List<String> listName) {
        WebRequestHelper.json_post(ChatActivity.this, URLText.USERBYIM, RequestParamsPool.getUserByIM(listName), new MyAsyncHttpResponseHandler(ChatActivity.this) {
            @Override
            public void onResponse(int statusCode, Header[] headers, byte[] responseBody) {
                String result=new String(responseBody);
                JSONObject object=new JSONObject();
            }
        });
    }
}
