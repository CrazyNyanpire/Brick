package acetecsemi.com.brick.application;


import java.util.List;
import java.util.Set;
import  acetecsemi.com.brick.core.domain.Platform;

public interface PlatformApplication {

	public Platform getPlatform(Long id);
	
	public void creatPlatform(Platform platform);
	
	public void updatePlatform(Platform platform);
	
	public void removePlatform(Platform platform);
	
	public void removePlatforms(Set<Platform> platforms);
	
	public List<Platform> findAllPlatform();
	
}

