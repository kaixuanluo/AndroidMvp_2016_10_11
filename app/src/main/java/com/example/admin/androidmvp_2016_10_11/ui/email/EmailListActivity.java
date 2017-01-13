package com.example.admin.androidmvp_2016_10_11.ui.email;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.androidmvp_2016_10_11.R;
import com.example.admin.androidmvp_2016_10_11.common.activity.BaseListActivity;
import com.example.admin.androidmvp_2016_10_11.common.callBack.BaseListCallBack;
import com.example.admin.androidmvp_2016_10_11.common.requestStatus.BaseListRequestStatus;
import com.example.admin.androidmvp_2016_10_11.module.response.MailResult;
import com.example.admin.androidmvp_2016_10_11.module.response.MailResult.Data.Mail;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/12 18:44 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/12 18:44 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class EmailListActivity extends BaseListActivity<EmailPresenter<MailResult, Mail, BaseListCallBack>,
        BaseListRequestStatus<MailResult, Mail>, MailResult, Mail> {

    @Override
    protected EmailPresenter createPresenter() {
        return new EmailPresenter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        refresh();
    }

    @Override
    protected HolderItem createItemViewHolder(ViewGroup parent) {
        return new EmailViewHolder(LayoutInflater.from(this).inflate(R.layout.item_emial, parent, false));
    }

    @Override
    protected void bindItemViewHolder(ViewHolder holder, Mail mail, final int position) {
        ((EmailViewHolder) holder).mItemEmailTime.setText(mail.getRecvTime());
        ((EmailViewHolder) holder).mItemEmailTitle.setText(mail.getTitle());
        ((EmailViewHolder) holder).mBtnTop.setVisibility(View.GONE);
        ((EmailViewHolder) holder).mBtnDelete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getBaseList().remove(position);
                getBaseHFAdapter().notifyItemRemoved(position);
            }
        });
    }

    @Override
    protected void loadData() {
        createPresenter().loadEmailData(0 + "", new LoadingCallback());
    }

    @Override
    protected void loadMoreData(Mail mail) {
        if(getBaseList().size() > 30) {
            createPresenter().loadEmailData(mail.getId() + "", new LoadingCallback());
        } else {
            createPresenter().loadEmailData(0 + "", new LoadingCallback());
        }
    }

    class EmailViewHolder extends HolderItem {
        @BindView(R.id.item_email_title)
        TextView mItemEmailTitle;
        @BindView(R.id.item_email_time)
        TextView mItemEmailTime;
        @BindView(R.id.btnTop)
        Button mBtnTop;
        @BindView(R.id.btnUnRead)
        Button mBtnUnRead;
        @BindView(R.id.btnDelete)
        Button mBtnDelete;

        public EmailViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
