package com.znsio.e2e.screen.swiggy;

import com.znsio.e2e.entities.Platform;
import com.znsio.e2e.runner.Runner;
import com.znsio.e2e.screen.swiggy.web.RestaurantProfileScreenWeb;
import com.znsio.e2e.tools.Driver;
import com.znsio.e2e.tools.Visual;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.log4j.Logger;

import static com.znsio.e2e.runner.Runner.fetchDriver;
import static com.znsio.e2e.runner.Runner.fetchEyes;

public abstract class RestaurantProfileScreen {

    private static final String SCREEN_NAME = RestaurantProfileScreen.class.getSimpleName();
    private static final Logger LOGGER = Logger.getLogger(SCREEN_NAME);

    public static RestaurantProfileScreen get() {
        Driver driver = fetchDriver(Thread.currentThread().getId());
        Platform platform = Runner.fetchPlatform(Thread.currentThread().getId());
        LOGGER.info(SCREEN_NAME + ": Driver type: " + driver.getType() + ": Platform: " + platform);
        Visual visually = fetchEyes(Thread.currentThread().getId());

        switch (platform) {
            case web:
                return new RestaurantProfileScreenWeb(driver, visually);
        }
        throw new NotImplementedException(SCREEN_NAME + " is not implemented in " + Runner.platform);
    }

    public abstract RestaurantProfileScreen addFoodItemsToCart(int unitOfItemsToAdd,String foodCategory);

    public abstract RestaurantProfileScreen addFoodItemsToCart(String foodCategory);

    public abstract RestaurantProfileScreen addFoodItemsToCart();
    public abstract int getItemsCountFromDishImage();

    public abstract int getItemsCountFromDishImage(String foodCategory);

    public abstract String getFoodItemNameToBeAdded();

    public abstract int getFoodItemOrderCount();

    public abstract RestaurantProfileScreen incrementCartValue();

    public abstract RestaurantProfileScreen decrementCartValueFromProfileSection(int itemsAlreadyAdded);

}
