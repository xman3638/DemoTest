package com.example.myapplication;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "onetable")
public class OneTableBean {
    @DatabaseField(generatedId = true, columnName = "messageId", unique = true)
    private int messageId;//主键
    @DatabaseField(columnName = "batchNo")
    private String batchNo;//批次号码	3
    @DatabaseField(columnName = "title")
    private String title;//标题	zzzz
    @DatabaseField(columnName = "content")
    private String content;//内容	zzz

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "OneTableBean{" +
                "messageId=" + messageId +
                ", batchNo='" + batchNo + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}