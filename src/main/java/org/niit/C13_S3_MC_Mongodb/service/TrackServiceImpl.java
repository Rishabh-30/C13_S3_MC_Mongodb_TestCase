package org.niit.C13_S3_MC_Mongodb.service;

import org.niit.C13_S3_MC_Mongodb.domain.Track;
import org.niit.C13_S3_MC_Mongodb.exception.ArtistNotFoundException;
import org.niit.C13_S3_MC_Mongodb.exception.TrackAlreadyExistExcepion;
import org.niit.C13_S3_MC_Mongodb.exception.TrackNotFoundException;
import org.niit.C13_S3_MC_Mongodb.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrackServiceImpl implements TrackService{
    @Autowired
    public TrackRepository trackRepository;

    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistExcepion {
        if(trackRepository.findById(track.getTrackId()).isPresent()){
            throw new TrackAlreadyExistExcepion();
        }
      return trackRepository.insert(track);
    }

    @Override
    public List<Track> getAllTrack() {
        return trackRepository.findAll();
    }

    @Override
    public boolean deleteTrack(int trackId) throws TrackNotFoundException {
        boolean flag = false;
        if(trackRepository.findById(trackId).isEmpty())
        {
            throw new TrackNotFoundException();
        }
        else {
            trackRepository.deleteById(trackId);
            flag = true;
        }
        return flag;
    }
    @Override
    public List<Track> getAllTracksByRatingGreaterThan4() {
        return trackRepository.findAllTracksFromRating();
    }

    @Override
    public List<Track> getAllTracksByArtistName(String artistName) throws ArtistNotFoundException {
        if(trackRepository.findAllTracksFromArtistName(artistName).isEmpty()){
            throw new ArtistNotFoundException();
        }
        return trackRepository.findAllTracksFromArtistName(artistName);
    }
}
