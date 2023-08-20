package pro.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.demo.Exceptions.WrongParam;
import pro.demo.services.StringList;
import pro.demo.services.StringListImpl;

@RestController
@RequestMapping("/ArrayList")
public class StringListController {
    private final StringList stringList;
    public StringListController(StringList stringList) {
        this.stringList = stringList;
    }
    @GetMapping("/add")
    public String add(@RequestParam(value = "Index", required = false) Integer index, @RequestParam("Item") String item) {
        if (index != null) {
            return stringList.add(index, item);
        } else {
            return stringList.add(item);
        }

    }
    @GetMapping("/set")
    public String set(@RequestParam("Index") int index, @RequestParam("Item") String item) {
        return stringList.set(index, item);
    }
    @GetMapping("/remove")
    public String remove(@RequestParam(value = "Item", required = false) String item,
                         @RequestParam(value = "Index", required = false) Integer index) {
        if (item == null) {
            return stringList.remove(index);
        } else if (index == null) {
            return stringList.remove(item);
        } else {
            throw new WrongParam();
        }

    }
    @GetMapping("/contains")
    public boolean contains(@RequestParam("Item") String item) {
        return stringList.contains(item);
    }
    @GetMapping("/indexOf")
    public int indexOf(@RequestParam("Item") String item) {
        return stringList.indexOf(item);
    }
    @GetMapping("/lastIndexOf")
    public int lastIndexOf(@RequestParam("Item") String item) {
        return stringList.lastIndexOf(item);
    }
    @GetMapping("/get")
    public String get(@RequestParam("Index") int index) {
        return stringList.get(index);
    }
    @GetMapping("/equals")
    public boolean equals(@RequestParam("list") StringListImpl otherList) {
        return stringList.equals(otherList);
    }
    @GetMapping("/size")
    public int size() {
        return stringList.size();
    }
    @GetMapping("/isEmpty")
    public boolean isEmpty() {
        return stringList.isEmpty();
    }
    @GetMapping("/clear")
    public String clear() {
        stringList.clear();
        return "List is clean";
    }
    @GetMapping("/toArray")
    public String[] toArray() {
        return stringList.toArray();
    }
}
