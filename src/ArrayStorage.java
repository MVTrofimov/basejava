import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++){
            if (storage[i] != null){
                storage[i] = null;
            } else{
                break;
            }
        }
    }

    void save(Resume r) {
        if (size() < storage.length){
            storage[size()] = r;
        }
    }

    Resume get(String uuid) {
        int flag = 0;
        Resume return_res = null;
        for (Resume resume : storage) {
            if (resume != null && Objects.equals(resume.toString(), uuid)) {
                flag = 1;
                return_res = resume;
                break;
            }
        }
        if (flag == 1) {
            return return_res;
        } else{
            return null;
        }
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++){
            int flag = 0;
            if (storage[i] != null && Objects.equals(storage[i].toString(), uuid)){
                flag = 1;
            }
            if (flag == 1){
                while (storage[i+1] != null){
                    storage[i] = storage[i+1];
                    i += 1;
                }
                storage[i] = null;
            }

        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] return_arr = new Resume[size()];
        for (int i = 0; i < size(); i++){
            return_arr[i] = storage[i];
        }
        return return_arr;
    }

    int size() {
        int count = 0;
        while (storage[count] != null){
            count += 1;
        }
        return count;
    }
}
