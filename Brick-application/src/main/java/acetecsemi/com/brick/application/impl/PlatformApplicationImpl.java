package acetecsemi.com.brick.application.impl;

import java.util.List;
import java.util.Set;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import acetecsemi.com.brick.application.PlatformApplication;
import acetecsemi.com.brick.core.domain.Platform;

@Named
@Transactional
public class PlatformApplicationImpl implements PlatformApplication {

	public Platform getPlatform(Long id) {
		return Platform.get(Platform.class, id);
	}
	
	public void creatPlatform(Platform platform) {
		platform.save();
	}
	
	public void updatePlatform(Platform platform) {
		platform .save();
	}
	
	public void removePlatform(Platform platform) {
		if(platform != null){
			platform.remove();
		}
	}
	
	public void removePlatforms(Set<Platform> platforms) {
		for (Platform platform : platforms) {
			platform.remove();
		}
	}
	
	public List<Platform> findAllPlatform() {
		return Platform.findAll(Platform.class);
	}
	
}
