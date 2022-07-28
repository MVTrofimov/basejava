import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            } else {
                break;
            }
        }
        size = 0;
    }

    void save(Resume r) {
        if (size < storage.length) {
            storage[size] = r;
            size += 1;
        }
    }

    Resume get(String uuid) {
        for (Resume resume : storage) {
            if (resume != null && Objects.equals(resume.toString(), uuid)) {
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            int flag = 0;
            if (storage[i] != null && Objects.equals(storage[i].toString(), uuid)) {
                flag = 1;
            }
            if (flag == 1) {
                while (storage[i + 1] != null) {
                    storage[i] = storage[i + 1];
                    i += 1;
                }
                storage[i] = null;
            }

        }
        size -= 1;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] return_arr = new Resume[size];
        for (int i = 0; i < size; i++) {
            return_arr[i] = storage[i];
        }
        return return_arr;
    }

    int size() {
        return size;
    }
}
