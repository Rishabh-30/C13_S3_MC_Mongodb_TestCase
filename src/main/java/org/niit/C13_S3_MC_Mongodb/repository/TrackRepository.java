package org.niit.C13_S3_MC_Mongodb.repository;

import org.niit.C13_S3_MC_Mongodb.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TrackRepository extends MongoRepository <Track,Integer>{
    @Query("{'trackRating':{$gt:4}}")
    List<Track> findAllTracksFromRating();
    @Query("{'trackArtist.artistName':{$in:[?0]}}")
    List<Track> findAllTracksFromArtistName(String artistName);

}
