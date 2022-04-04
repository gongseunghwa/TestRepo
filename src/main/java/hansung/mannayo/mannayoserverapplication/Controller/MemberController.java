package hansung.mannayo.mannayoserverapplication.Controller;


import hansung.mannayo.mannayoserverapplication.Model.Entity.Member;
import hansung.mannayo.mannayoserverapplication.Model.Entity.Review;
import hansung.mannayo.mannayoserverapplication.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/members")
public class MemberController {

    @Autowired
    MemberService service;

    @GetMapping
    public ResponseEntity<List<Member>> findAll(){
        List<Member> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> findbyNickName(@PathVariable Long id){
        Member obj = service.findbyId(id);
        return ResponseEntity.ok().body(obj);

    }

    @PostMapping
    public ResponseEntity<Member> insert(Member obj){
        return ResponseEntity.ok(service.insert(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> update(@PathVariable Long id, @RequestBody Member obj){
        obj = service.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }


}
