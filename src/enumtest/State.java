package enumtest;

public enum State implements ICanReadState {

	Normal("正常态", 1), Update("已更新", 2), Deleted("已删除", 3), Fired("已屏蔽", 4);

	private String name;
	private int index;

	private State(String name, int index) {
		this.name = name;
		this.index = index;
	}

	// 接口方法1

	@Override
	public String getState() {
		return this.name;
	}

	// 接口方法2
	@Override
	public void read() {
		System.out.println(this.index + ":" + this.name);
	}

}
