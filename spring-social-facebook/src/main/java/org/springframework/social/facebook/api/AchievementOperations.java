/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.facebook.api;

import java.util.List;

/**
 * Defines operations for working with Facebook achievements.
 * @author Craig Walls
 * @since 2.0
 */
public interface AchievementOperations {

	Achievement getAchievement(String achievementId);

	List<Achievement> getAchievements();

	String postAchievement(String achievementUrl);

	void removeAchievement(String achievementUrl);

	List<AchievementType> getAchievementTypes();
	
	AchievementType getAchievementType(String achievementTypeId);
	
	void createAchievementType(String achievementTypeUrl, int displayOrder);
	
	void removeAchievementType(String achievementTypeUrl);
	
}
