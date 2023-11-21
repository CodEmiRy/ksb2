package pl.codemiry.ksb2;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videos")
public class VideoApi {
    private final List<Video> videoList;

    public VideoApi() {
        this.videoList = new ArrayList<>();
        videoList.add(new Video(1L, "Title1", "url1"));
        videoList.add(new Video(2L, "Title2", "url2"));
    }

    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Video>> getVideos() {
        return new ResponseEntity<>(videoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable long id) {
        Optional<Video> first = videoList.stream().filter(i -> i.getId() == id).findFirst();
        if (first.isPresent()) {
            return new ResponseEntity<>(first.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity addVideo(@RequestBody Video video) {
        boolean add = videoList.add(video);
        if (add) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping
    public ResponseEntity modVideo(@RequestBody Video newvideo) {
        Optional<Video> first = videoList.stream().filter(i -> i.getId() == newvideo.getId()).findFirst();
        if (first.isPresent()) {
            videoList.remove(first.get());
            videoList.add(newvideo);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Video> removeVideo(@PathVariable long id) {
        Optional<Video> first = videoList.stream().filter(i -> i.getId() == id).findFirst();
        if (first.isPresent()) {
            videoList.remove(first.get());
            return new ResponseEntity<>(first.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
