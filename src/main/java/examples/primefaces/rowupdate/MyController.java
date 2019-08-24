	package examples.primefaces.rowupdate;
	
	import java.util.ArrayList;
	import java.util.Date;
	import java.util.List;
	
	import javax.annotation.PostConstruct;
	import javax.faces.bean.ManagedBean;
	import javax.faces.bean.ViewScoped;
	
	@ManagedBean
	@ViewScoped
	public class MyController {
		
		private List<MyEntity> entities;
	
		@PostConstruct
		public void init() {
			this.entities = new ArrayList<MyEntity>(10);
			for(int i = 0; i < 10; ++i) {
				this.entities.add(new MyEntity(i));
			}
		}
		
		public List<MyEntity> getAllEntities() {
			return entities;
		}
		
		public void increment(MyEntity myEntity) {
			myEntity.increment();
		}
		
		public class MyEntity {
			private int id, counter;
			private Date lastUpdate;
	
			public MyEntity(int id) {
				this.id = id;
				this.counter = 0;
				this.lastUpdate = new Date();
			}
			
			public void increment() {
				this.counter++;
				this.lastUpdate = new Date();
			}
	
			public int getId() {
				return id;
			}
	
			public int getCounter() {
				return counter;
			}
			
			public Date getLastUpdate() {
				return lastUpdate;
			}
		}
	
	}
