package com.wang.response.message;

import java.util.List;

/**
 * Created by wxl on 2015/11/14.
 * �ظ�ͼ����Ϣ
 */
public class NewsMessage extends BaseMessage {
    //ͼ����Ϣ����������Ϊ10������
    private int ArticleCount;
    //����ͼ����Ϣ��Ϣ��Ĭ�ϵ�һ��itemΪ��ͼ,ע�⣬���ͼ��������10���򽫻�����Ӧ
    private List<Article> Articles;

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        Articles = articles;
    }
}
