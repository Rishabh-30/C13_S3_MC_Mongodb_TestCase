package org.niit.C13_S3_MC_Mongodb.service;

import org.niit.C13_S3_MC_Mongodb.domain.Track;
import org.niit.C13_S3_MC_Mongodb.exception.ArtistNotFoundException;
import org.niit.C13_S3_MC_Mongodb.exception.TrackAlreadyExistExcepion;
import org.niit.C13_S3_MC_Mongodb.exception.TrackNotFoundException;

import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track)throws TrackAlreadyExistExcepion;
    public List<Track> getAllTrack();
    public boolean deleteTrack(int trackId) throws TrackNotFoundException;
    public List<Track> getAllTracksByRatingGreaterThan4();
    public List<Track> getAllTracksByArtistName(String artistName)throws ArtistNotFoundException;
}
