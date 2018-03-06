package com.jia.touchhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MotionEvent;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 主界面
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_edit)
    TextView tvEdit;
    @BindView(R.id.rv_mine)
    RecyclerView rvMine;

    private List<String> daos = new ArrayList<>();

    private MineAdapter mineAdapter;

    private ItemTouchHelper itemTouchHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initDaos();

        mineAdapter = new MineAdapter(this, daos);
        GridLayoutManager gm = new GridLayoutManager(this, 4);

        itemTouchHelper = new ItemTouchHelper(new MineTouchCallback(mineAdapter));
        itemTouchHelper.attachToRecyclerView(rvMine);

        rvMine.setLayoutManager(gm);
        rvMine.setAdapter(mineAdapter);


    }

    /**
     * 初始化频道
     */
    private void initDaos() {
        for (int i = 0; i < 17; i++) {
            daos.add("频道" + (i + 1));
        }
    }

    @OnClick(R.id.tv_edit)
    public void onViewClicked() {

        if(mineAdapter.isEdit()){
            mineAdapter.setEditable(false);
            tvEdit.setText("编辑");
        }else{
            mineAdapter.setEditable(true);
            tvEdit.setText("完成");

        }

    }
}
