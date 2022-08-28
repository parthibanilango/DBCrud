package com.greatlearning.db.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "articles")
public class Article {

	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	
	public Article(String filename, String author, String title, String Keywords, long chunkSize, long length,
			String uploadDate) {
		super();
		this.filename = filename;
		this.author = author;
		this.title = title;
		this.Keywords = Keywords;
		this.chunkSize = chunkSize;
		this.length = length;
		this.uploadDate = uploadDate;
	}

	private ObjectId _id;
	private String filename;
    private String author;
    
    private String title;
    
    private String Keywords;
    
    private long chunkSize;
    
    private long length;
    
    private String uploadDate;


    public Article() {

    }

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return filename;
	}


	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.filename = fileName;
	}


	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}


	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the keywords
	 */
	public String getKeywords() {
		return Keywords;
	}


	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(String keywords) {
		this.Keywords = keywords;
	}


	/**
	 * @return the chunkSize
	 */
	public long getChunkSize() {
		return chunkSize;
	}


	/**
	 * @param chunkSize the chunkSize to set
	 */
	public void setChunkSize(long chunkSize) {
		this.chunkSize = chunkSize;
	}


	/**
	 * @return the length
	 */
	public long getLength() {
		return length;
	}


	/**
	 * @param length the length to set
	 */
	public void setLength(long length) {
		this.length = length;
	}


	/**
	 * @return the uploadDate
	 */
	public String getUploadDate() {
		return uploadDate;
	}


	/**
	 * @param uploadDate the uploadDate to set
	 */
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	/**
	 * @return the _id
	 */
	public ObjectId get_id() {
		return _id;
	}

	/**
	 * @param _id the _id to set
	 */
	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Article [" + "fileName=" + filename + ", author=" + author + ", title=" + title
				+ ", keywords=" + Keywords + ", chunkSize=" + chunkSize + ", length=" + length + ", uploadDate="
				+ uploadDate + "]";
	}

}