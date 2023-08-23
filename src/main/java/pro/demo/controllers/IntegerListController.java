package pro.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.demo.Exceptions.WrongParam;
import pro.demo.services.IntegerList;
import pro.demo.services.IntegerListImpl;

import java.util.Arrays;

@RestController
@RequestMapping("/ArrayList")
public class IntegerListController {
    private final IntegerList integerList;
    public IntegerListController(IntegerList integerList) {
        this.integerList = integerList;
    }
    @GetMapping("/add")
    public Integer add(@RequestParam(value = "Index", required = false) Integer index, @RequestParam("Item") Integer item) {
        if (index != null) {
            return integerList.add(index, item);
        } else {
            return integerList.add(item);
        }

    }
    @GetMapping("/set")
    public Integer set(@RequestParam("Index") int index, @RequestParam("Item") Integer item) {
        return integerList.set(index, item);
    }
    @GetMapping("/remove")
    public Integer remove(@RequestParam(value = "Item", required = false) Integer item) {

        return integerList.remove(item);


    }
    @GetMapping("/removeByIndex")
    public Integer remove(@RequestParam(value = "Index", required = false) int index) {
        return integerList.removeByIndex(index);

    }
    @GetMapping("/contains")
    public boolean contains(@RequestParam("Item") Integer item) {
        return integerList.contains(item);
    }
    @GetMapping("/indexOf")
    public int indexOf(@RequestParam("Item") Integer item) {
        return integerList.indexOf(item);
    }
    @GetMapping("/lastIndexOf")
    public int lastIndexOf(@RequestParam("Item") Integer item) {
        return integerList.lastIndexOf(item);
    }
    @GetMapping("/get")
    public Integer get(@RequestParam("Index") int index) {
        return integerList.get(index);
    }
    @GetMapping("/equals")
    public boolean equals(@RequestParam("list") IntegerListImpl otherList) {
        return integerList.equals(otherList);
    }
    @GetMapping("/size")
    public int size() {
        return integerList.size();
    }
    @GetMapping("/isEmpty")
    public boolean isEmpty() {
        return integerList.isEmpty();
    }
    @GetMapping("/clear")
    public String clear() {
        integerList.clear();
        return "List cleaned";
    }
    @GetMapping("/toArray")
    public Integer[] toArray() {
        return integerList.toArray();
    }
    @GetMapping("/sort")
    public String sort() {
        integerList.sortSelection();
        return "List sorted";
    }
    @GetMapping("/generate")
    public String generateRandomList() {
        integerList.randomArrays();
        return Arrays.toString(integerList.toArray());
    }
}
