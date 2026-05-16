package az.developia.studentManagementSystem.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Book {
	private Integer id;
	private String title;
	private String author;
	private Integer publicationYear;
	private LocalDateTime registerDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}

	public LocalDateTime getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}

	public Book(Integer id, String title, String author, Integer publicationYear, LocalDateTime registerDate) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.registerDate = registerDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, id, publicationYear, registerDate, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(id, other.id)
				&& Objects.equals(publicationYear, other.publicationYear)
				&& Objects.equals(registerDate, other.registerDate) && Objects.equals(title, other.title);
	}

}
