package collection;

import stored.Worker;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;

/**
 * I think everything is understandable
 */

public class WorkerCollection implements CollectionManager<Worker>, Iterable<Worker> {

    private ArrayList<Worker> collection;
    private HashSet<Long> ids;

    @Override
    public void forEach(Consumer<? super Worker> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Worker> spliterator() {
        return Iterable.super.spliterator();
    }

    @Override
    public Iterator<Worker> iterator() {
        return this.collection.iterator();
    }

    private LocalDate initDate;

    public WorkerCollection() {
        collection = new ArrayList<>();
        ids = new HashSet<>();
        initDate = LocalDate.now();
    }

    public String getInfo() {
        String res = "";
        res += "<Worker> collection manager\n";
        res += "Collection created on: " + this.initDate + "\n";
        res += "Number of elements in collection: " + this.collection.size();
        return res;
    }

    @Override
    public boolean add(Worker element) {
        if (element.getId() == 0)
            element.setId(this.generateId());
        else if (ids.contains(element.getId())) {
            System.out.println("Could not add element because its ID is reserved");
            return false;
        }
        else
            ids.add(element.getId());
        collection.add(element);
        return true;
    }

    @Override
    public void updateId(Worker element) {
        boolean ok = false;
        for (int i = 0; i < this.collection.size(); i++) {
            if (this.collection.get(i).getId().equals(element.getId())) {
                this.collection.set(i, element);
                System.out.println("Element with id " + element.getId() + " has been updated");
                ok = true;
            }
        }
        if (!ok)
            System.out.println("No element with such index");
    }

    @Override
    public void removeById(long id) {
        boolean ok = false;
        for (int i = 0; i < this.collection.size(); i++) {
            if (this.collection.get(i).getId().equals(id)) {
                this.collection.remove(i);
                System.out.println("Element with id " + id + " has been removed");
                ok = true;
                break;
            }
        }
        if (!ok)
            System.out.println("No element with such index");
    }

    @Override
    public boolean isEmpty() {
        return this.collection.isEmpty();
    }

    @Override
    public void clear() {
        this.collection.clear();
        System.out.println("The collection has been cleared");
    }

    @Override
    public void removeFirst() {
        if (this.collection.size() != 0)
            this.collection.remove(0);
    }

    @Override
    public ArrayList<Worker> getCollection() {
        return this.collection;
    }

    @Override
    public void sort() {
        Collections.sort(this.collection);
        System.out.println("Collection has been sorted");
    }

    @Override
    public long generateId() {
        if (collection.isEmpty()) {
            ids.add(1L);
            return 1L;
        }
        long id = collection.get(collection.size() - 1).getId() + 1;
        while (ids.contains(id))
            id++;
        ids.add(id);
        return id;
    }

}
