package com.waylau.spring.boot.blog.domain;

import com.github.rjeschke.txtmark.Processor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.security.Timestamp;

/**
 * Crete by Marlon
 * Create Date: {DATE}
 * Class Describe
 **/
@Entity  //����ʵ��
public class Blog implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // ����
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ����������
    private Long id; // �û���Ψһ��ʶ

    @NotEmpty(message = "���ⲻ��Ϊ��")
    @Size(min = 2, max = 50)
    @Column(nullable = false, length = 50) // ӳ��Ϊ�ֶΣ�ֵ����Ϊ��
    private String title;

    @NotEmpty(message = "ժҪ����Ϊ��")
    @Size(min = 2, max = 300)
    @Column(nullable = false) // ӳ��Ϊ�ֶΣ�ֵ����Ϊ��
    private String summary;

    @Lob  // �����ӳ�� MySQL �� Long Text ����
    @Basic(fetch = FetchType.LAZY) // ������
    @NotEmpty(message = "���ݲ���Ϊ��")
    @Size(min = 2)
    @Column(nullable = false) // ӳ��Ϊ�ֶΣ�ֵ����Ϊ��
    private String content;

    @Lob  // �����ӳ�� MySQL �� Long Text ����
    @Basic(fetch = FetchType.LAZY) // ������
    @NotEmpty(message = "���ݲ���Ϊ��")
    @Size(min = 2)
    @Column(nullable = false) // ӳ��Ϊ�ֶΣ�ֵ����Ϊ��
    private String htmlContent; // �� md תΪ html

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false) // ӳ��Ϊ�ֶΣ�ֵ����Ϊ��
    @org.hibernate.annotations.CreationTimestamp// �����ݿ��Զ�����ʱ��
    private Timestamp createTime;

    @Column(name = "readSize")
    private Integer readSize = 0; // ���������Ķ���

    @Column(name = "commentSize")
    private Integer commentSize = 0;  // ������

    @Column(name = "voteSize")
    private Integer voteSize = 0;  // ������

    @Column(name = "tags", length = 100)
    private String tags;  // ��ǩ


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getReadSize() {
        return readSize;
    }

    public void setReadSize(Integer readSize) {
        this.readSize = readSize;
    }

    public Integer getCommentSize() {
        return commentSize;
    }

    public void setCommentSize(Integer commentSize) {
        this.commentSize = commentSize;
    }

    public Integer getVoteSize() {
        return voteSize;
    }

    public void setVoteSize(Integer voteSize) {
        this.voteSize = voteSize;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
