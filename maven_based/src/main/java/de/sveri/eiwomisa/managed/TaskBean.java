package de.sveri.eiwomisa.managed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.transaction.annotation.Transactional;

import de.sveri.eiwomisa.model.Task;

// @URLMapping(id = "tasks", pattern = "/tasks/#{taskBean.fromDate}", viewId =
// "/pages/tasks/tasks.xhtml")
// @URLMapping(id = "tasks", pattern = "/tasks", viewId =
// "/pages/tasks/tasks.xhtml")
@ManagedBean
@ViewScoped
@Transactional
public class TaskBean implements Serializable {

	private static final long serialVersionUID = -5686600179121754166L;

	@Inject
	// TaskDao taskDao;
	private List<Task> tasks;// = new ArrayList<Task>();

	private boolean done;

	private String name;

	private String description;

	private Date dueTo;

	private boolean reloadTasks;

	private String fromDate;

	@PersistenceContext
	protected EntityManager em;

	public TaskBean() {
		tasks = new ArrayList<Task>();
		Task test = new Task();
		test.setName("testName");

		tasks.add(test);

		doIt();

	}

	@Transactional
	private void doIt() {

		Task t = new Task();
		t.setName("test");
		em.merge(t);

	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> taskss) {
		tasks = taskss;
	}

	public void save(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Car Edited",
				((Task) event.getObject()).getName());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void createTasks() {
		// for (int i = 0; i < 10; i++) {
		// Task task = new Task();
		// task.setName("aame_" + i);
		// task.setDueTo(new Date());
		// task.setDone(i % 2 == 0 ? true : false);
		// taskDao.persist(task);
		// }
		System.out.println("creat tasks");
	}

	public void addTask() {

		FacesMessage msg = null;
		Task task = new Task();
		boolean taskAdded = false;

		task.setDescription(getDescription());
		task.setDone(isDone());
		task.setDueTo(getDueTo());
		task.setName(getName());

		// if (taskDao.persist(task) != null) {
		// taskAdded = true;
		// msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Task",
		// getName() + " added.");
		// clearTasks();
		// // setTasks(null);
		// } else {
		// taskAdded = false;
		// msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Task Error",
		// "Something went wrong on adding task.");
		// }
		//
		// RequestContext.getCurrentInstance().reset("formTaskTable:dlgAddTask");

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	private void clearTasks() {
		tasks.clear();
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueTo() {
		return dueTo;
	}

	public void setDueTo(Date dueTo) {
		this.dueTo = dueTo;
	}

	public boolean isReloadTasks() {
		return reloadTasks;
	}

	public void setReloadTasks(boolean reloadTasks) {
		this.reloadTasks = reloadTasks;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

}
