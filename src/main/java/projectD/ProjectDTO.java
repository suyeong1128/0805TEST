package projectD;

public class ProjectDTO {
	private int id;
	private String name;
	private String ssn;
	private String phone;
	private int num;
	private String writer;
	private String title;
	private String content;
	private String regtime;
	private int hits;
	
	
	public ProjectDTO(String writer, String title, String content) {
		super();
		this.writer = writer;
		this.title = title;
		this.content = content;
	}

	public ProjectDTO(int id, String name, String ssn, String phone, int num, String writer, String title,
			String content, String regtime, int hits) {
		super();
		this.id = id;
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regtime = regtime;
		this.hits = hits;
	}
	
	public ProjectDTO(int num, String writer, String title, String content, String regtime, int hits) {
		super();
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regtime = regtime;
		this.hits = hits;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}

	@Override
	public String toString() {
		return "ProjectDTO [id=" + id + ", name=" + name + ", ssn=" + ssn + ", phone=" + phone + ", num=" + num
				+ ", writer=" + writer + ", title=" + title + ", content=" + content + ", regtime=" + regtime
				+ ", hits=" + hits + "]";
	}
}
