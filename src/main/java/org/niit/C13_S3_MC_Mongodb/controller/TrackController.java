package org.niit.C13_S3_MC_Mongodb.controller;

import org.niit.C13_S3_MC_Mongodb.domain.Track;
import org.niit.C13_S3_MC_Mongodb.exception.ArtistNotFoundException;
import org.niit.C13_S3_MC_Mongodb.exception.TrackAlreadyExistExcepion;
import org.niit.C13_S3_MC_Mongodb.exception.TrackNotFoundException;
import org.niit.C13_S3_MC_Mongodb.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2")

public class TrackController {


        private TrackService trackService;
        @Autowired
        public TrackController(TrackService trackService) {
            this.trackService = trackService;
        }
        @PostMapping( "/track")
        public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistExcepion {
            ResponseEntity responseEntity = null;
            try{
                responseEntity = new ResponseEntity<>(trackService.saveTrack(track), HttpStatus.CREATED);
            }catch(TrackAlreadyExistExcepion e){
                throw new TrackAlreadyExistExcepion();
            }catch(Exception e){
                responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return responseEntity;
        }
        @GetMapping( "/tracks")
        public ResponseEntity<?> getAllTracks(){
            ResponseEntity responseEntity = null;
            try{
                responseEntity = new ResponseEntity(trackService.getAllTrack(), HttpStatus.OK);
            }catch (Exception exception){
                responseEntity = new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return responseEntity;
        }
        @DeleteMapping("/track/{trackId}")
        public ResponseEntity<?> deleteTrack(@PathVariable int trackId) throws TrackNotFoundException {
            ResponseEntity responseEntity = null;
            try {
                trackService.deleteTrack(trackId);
                responseEntity = new ResponseEntity("Successfully deleted !!!", HttpStatus.OK);
            } catch (TrackNotFoundException e) {
                throw new TrackNotFoundException();
            }
            catch (Exception exception){
                responseEntity = new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return responseEntity;
        }
        @GetMapping( "/track4")
        public ResponseEntity<?> getAllTracksByRatingGreaterThan4(){
            ResponseEntity responseEntity = null;
            try{
                responseEntity = new ResponseEntity<>(trackService.getAllTracksByRatingGreaterThan4(),HttpStatus.OK);
            }catch (Exception e){
                responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return responseEntity;
        }
        @GetMapping("/track/{artistName}")
        public ResponseEntity<?> getAllTracksByArtistName(@PathVariable String artistName) throws ArtistNotFoundException {
            ResponseEntity responseEntity = null;
            try{
                responseEntity = new ResponseEntity(trackService.getAllTracksByArtistName(artistName),HttpStatus.FOUND);
            }catch(ArtistNotFoundException exception){
                throw new ArtistNotFoundException();
            }catch(Exception e){
                responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return responseEntity;
        }



}
