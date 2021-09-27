package com.kh.exam11;

public class Worker extends Person implements Soldier, Sport {

	public Worker(String name, int age, char gender) {
		super(name, age, gender);
	}
	
	@Override
	public void addAge() {
		this.setAge(getAge() + 1);
	}

	@Override
	public void run() {
		System.out.println(this.getName() + "이(가) 달리기 운동중 입니다.");
	}

	@Override
	public void jump() {
		System.out.println(this.getName() + "이(가)점프 운동을 하고 있습니다.");
	}

	@Override
	public void stretching() {
		System.out.println(this.getName() + "이(가)스트레칭을 하고 있습니다.");
	}

	@Override
	public void shooting() {
		System.out.println(this.getName() + "이(가)사격을 하고 있습니다.");
	}

	@Override
	public void work() {
		System.out.println(this.getName() + "이(가)근무 중 입니다.");
	}

	@Override
	public void training() {
		System.out.println(this.getName() + "이(가)훈련을 하고 있습니다.");
	}

	@Override
	public void battle() {
		System.out.println(this.getName() + "이(가)각개전투를 수행하고 있습니다.");
	}

}
