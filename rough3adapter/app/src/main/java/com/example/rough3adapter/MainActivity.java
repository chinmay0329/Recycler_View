package com.example.rough3adapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.SearchView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private static final String HI="http://crm123midbrains.000webhostapp.com/api/viewLead.php";
    private List<viewLeadsItem> list_data;
    private RecyclerView.Adapter adapter;
   // private RecyclerView recyclerView;
   // private SearchView searchView;


    //private static final String HI = "https://uniqueandrocode.000webhostapp.com/hiren/androidweb.php";
    private RecyclerView rv;
    //private List<List_Data>list_data;
   // private MyAdapter adapter;
   // @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv=(RecyclerView)findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        list_data=new ArrayList<>();
        adapter=new RecyclerViewAdapter(list_data,this);

        getData();

    }

    private void getData() {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, HI, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray  array=jsonObject.getJSONArray("data");
                    for (int i=0; i<array.length(); i++){
                        JSONObject ob=array.getJSONObject(i);
                        //viewLeadsItem ld=new viewLeadsItem();
                        viewLeadsItem movie = new viewLeadsItem();
                        movie.setLead_cust_firstname(jsonObject.getString("lead_cust_firstname"));
                        movie.setLead_cust_lastname(jsonObject.getString("lead_cust_lastname"));
                        movie.setLead_cust_email(jsonObject.getString("lead_cust_email"));
                        movie.setLead_cust_mobile(jsonObject.getString("lead_cust_mobile"));
//                                (ob.getString("lead_cust_firstname"),
//                                ob.getString("lead_cust_lastname"),ob.getString("lead_cust_email"),
//                                ob.getString("lead_cust_mobile"));
                        list_data.add(movie);
                    }
                    rv.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }




//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.searchview,menu);
//        final MenuItem menuItem=menu.findItem(R.id.search);
//        searchView=(SearchView)menuItem.getActionView();
//        ((EditText)searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text)).setHintTextColor(getResources().getColor(R.color.white));
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                if (!searchView.isIconified()){
//                    searchView.setIconified(true);
//                }
//                menuItem.collapseActionView();
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                final List&lt;ActorsList>filterModList=filter(actorsLists,newText);
//                actorsAdapter.setfilter(filterModList);
//                return true;
//            }
//        });
//        return true;
//
//    }
//    private List&lt;ActorsList>filter(List&lt;ActorsList>hi,String query){
//    query=query.toLowerCase();
//    final List&lt;ActorsList>filterModeList=new ArrayList&lt;>();
//    for (ActorsList modal:hi){
//        final String text=modal.getName().toLowerCase();
//        if (text.startsWith(query)){
//            filterModeList.add(modal);
//        }
//    }
//    return filterModeList;
//}

}

/*
 JSONObject object=jsonArray.getJSONObject(i);
                        viewLeadsItem actorsList=new viewLeadsItem(object.getString("lead_cust_firstname"),
                                object.getString("lead_cust_lastname"),object.getString("lead_cust_email"),
                                object.getString("lead_cust_mobile"));
 */