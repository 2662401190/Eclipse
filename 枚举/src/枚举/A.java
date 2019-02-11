package 枚举;


public enum A implements C {
	
	
	ASD("hewei",20){
		

		@Override
		public void sd() {
			// TODO 自动生成的方法存根
			
		}
	};
	
	String name;
	
	int age;

	
	private A(String name, int age) {
		this.name = name;
		this.age = age;
	}



	}

 class D implements C {
	
	


	
	private final	String name;
	private	final String age;
	
	
	private D(String name, String age) {
		this.name = name;
		this.age = age;
	}


	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}


	@Override
	public void sd() {
		// TODO 自动生成的方法存根
		
	}


	

}



