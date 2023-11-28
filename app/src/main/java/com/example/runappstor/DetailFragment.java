package com.example.runappstor;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.example.runappstor.Database.CreateDatabase;
import com.example.runappstor.EntityDao.ListStoryDao;

public class DetailFragment extends Fragment {
    private TextView viewAuthor, viewProductionDate, viewUpdateDay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate layout for the fragment
        View view = inflater.inflate(R.layout.activity_detail, container, false);
        viewAuthor = view.findViewById(R.id.textViewAuthor);
        viewProductionDate = view.findViewById(R.id.textViewProductionDate);
        viewUpdateDay = view.findViewById(R.id.textViewUpdateDay);

        CreateDatabase db = CreateDatabase.getInstance(requireContext());
        ListStoryDao listStoryDao = db.listStoryDao();

        // Lấy giá trị storyValue từ Intent
        String storyCode = requireActivity().getIntent().getStringExtra("storyValue");
            // Tiếp tục xử lý dữ liệu

            String author = listStoryDao.getAuthor(storyCode);
            String productionDate = listStoryDao.getProductionDay(storyCode);
            String updateDay = listStoryDao.getUpdateDay(storyCode);

            viewAuthor.setText(author);
            viewProductionDate.setText(productionDate);
            viewUpdateDay.setText(updateDay);

        return view;



    }
}
