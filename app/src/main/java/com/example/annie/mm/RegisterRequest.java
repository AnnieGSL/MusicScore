package com.example.annie.mm;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Annie on 13-04-2017.
 */

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://127.0.0.1:80/xampp/MusicScore/Register.php"; //CAMBIAR!!!
    private Map<String, String> params;

    public RegisterRequest(String name, String user, int age, String password, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("age", age + "");
        params.put("username", user);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
