package johnleung.posms.db;

import java.util.ArrayList;
import java.util.List;

import johnleung.posms.R;
import johnleung.posms.bean.CategoryBean;
import johnleung.posms.bean.OrderBean;
import johnleung.posms.bean.ProductBean;

public class TestData {
    public static List<OrderBean> myOrders = new ArrayList<OrderBean>();
    public static List<ProductBean> myFavorite = new ArrayList<ProductBean>();

    public static CategoryBean[] categories = new CategoryBean[]{
            new CategoryBean("Appetizer", R.drawable.category_appetizer),
            new CategoryBean("Rice", R.drawable.category_rice),
            new CategoryBean("Noodles", R.drawable.category_noodles),
            new CategoryBean("Desserts", R.drawable.category_desserts),
            new CategoryBean("Drinks", R.drawable.category_drinks),
            new CategoryBean("Wine", R.drawable.category_wine)
    };
    public static ProductBean[][] products = new ProductBean[][]{
            {
                    // Appetizer
                    new ProductBean("Fried Tofu", 18, R.drawable.appetizer_fried_tofu, "【Material】\n" +
                            "Egg tofu 2 boxes\n" +
                            "Frying powder:\n" +
                            "Corn flour 100 grams\n" +
                            "2 eggs\n" +
                            "Bread flour 100 grams\n" +
                            "\n" +
                            "[doing]\n" +
                            "1. Each egg tofu is cut into 12 pieces; the eggs are labeled as egg, and the tofu is evenly coated with corn flour.\n" +
                            "2. Next, wrap egg tofu with recipe 1 in egg liquid.\n" +
                            "3. Finally, the egg tofu of the method 2 is evenly crushed with bread flour, and the steps 1 to 3 are completed once.\n" +
                            "4. Wait until the method 3 material is completely immersed in the steps, heat a pan, add about 400cc of salad oil, heat to about 180 °C, throw in a little bread flour, if the bread flour will not sink and immediately Foaming means that the oil is hot enough to be fried.\n" +
                            "5. Put the processed egg tofu in the order 3 into the pan of practice 4 and fry it.\n" +
                            "6. To be practiced 5 fry the skin into golden yellow can be picked up."),
                    new ProductBean("Pickled Cucumber", 13, R.drawable.appetizer_pickled_cucumber, "【Material】\n" +
                            "Gherkin 600 grams\n" +
                            "Bruschetta 10 grams\n" +
                            "Salt 15 grams\n" +
                            "[seasoning]\n" +
                            "Pepper sauce 50 grams\n" +
                            "White soy sauce 2 tablespoons\n" +
                            "Salt\n" +
                            "Fine sugar 25 grams\n" +
                            "Water 150cc\n" +
                            "Sesame oil 1 tsp\n" +
                            "\n" +
                            "[doing]\n" +
                            "1. Wash the cucumbers and cut off the head and tail; add a uniform piece of salt and knead until soft.\n" +
                            "2. Put the gherkin of Practice 1 into a drainable basket and press the cucumber over with a heavy object to make it slowly out of water for about 1 day.\n" +
                            "3. Stir all the pickle sauces; remove the gherkins from recipe 3 and cut them into small pieces.\n" +
                            "4. Stir the marinade with the cucumber segments and mix well for serving."),
                    new ProductBean("Pickled Radish", 15, R.drawable.appetizer_pickled_radish, "【Material】\n" +
                            "White radish 1\n" +
                            "Salt 1 tbsp\n" +
                            "[seasoning]\n" +
                            "Hot bean paste 100 grams\n" +
                            "Fine sugar 25 grams\n" +
                            "White vinegar 1 tbsp\n" +
                            "Rice wine 1 tbsp\n" +
                            "1 tbsp of minced garlic\n" +
                            "Cold water 150cc\n" +
                            "1/2 tbsp sesame oil\n" +
                            "\n" +
                            "[doing]\n" +
                            "1. The white radish skin is washed and cut into slices. Add salt and stir it evenly for about 15 minutes.\n" +
                            "2. Put the white radish juice of the method 1 into the white radish juice by hand. After draining the broth, place the white radish slice in a drainable basket and press it with a heavy object and let it stand overnight (8 hours or more. ).\n" +
                            "3. Rub the white radish slices of Practice 3 with cold water and place them in a drainable basket. Hold down the weight and allow to stand for about 1 hour.\n" +
                            "4. Add cold granulated sugar in marinade sauce, add fine sugar, mix well, then mix in other marinade sauce ingredients and mix well.\n" +
                            "5. Remove the white radish slices that have been treated in Practice 3 and add the marinade in Practice 4 and marinate it for about 2 days.")
            },
            {
                    // Rice
                    new ProductBean("Fired Rice", 45, R.drawable.rice_fired_rice,"【Material】\n" +
                            "Gherkin 600 grams\n" +
                            "Bruschetta 10 grams\n" +
                            "Salt 15 grams\n" +
                            "[seasoning]\n" +
                            "Pepper sauce 50 grams\n" +
                            "White soy sauce 2 tablespoons\n" +
                            "Salt\n" +
                            "Fine sugar 25 grams\n" +
                            "Water 150cc\n" +
                            "Sesame oil 1 tsp\n" +
                            "\n" +
                            "[doing]\n" +
                            "1. Wash the cucumbers and cut off the head and tail; add a uniform piece of salt and knead until soft.\n" +
                            "2. Put the gherkin of Practice 1 into a drainable basket and press the cucumber over with a heavy object to make it slowly out of water for about 1 day.\n" +
                            "3. Stir all the pickle sauces; remove the gherkins from recipe 3 and cut them into small pieces.\n" +
                            "4. Stir the marinade with the cucumber segments and mix well for serving."),
                    new ProductBean("Braised Pork on rice", 51, R.drawable.rice_braised_pork_on_rice,"【Material】\n" +
                            "Gherkin 600 grams\n" +
                            "Bruschetta 10 grams\n" +
                            "Salt 15 grams\n" +
                            "[seasoning]\n" +
                            "Pepper sauce 50 grams\n" +
                            "White soy sauce 2 tablespoons\n" +
                            "Salt\n" +
                            "Fine sugar 25 grams\n" +
                            "Water 150cc\n" +
                            "Sesame oil 1 tsp\n" +
                            "\n" +
                            "[doing]\n" +
                            "1. Wash the cucumbers and cut off the head and tail; add a uniform piece of salt and knead until soft.\n" +
                            "2. Put the gherkin of Practice 1 into a drainable basket and press the cucumber over with a heavy object to make it slowly out of water for about 1 day.\n" +
                            "3. Stir all the pickle sauces; remove the gherkins from recipe 3 and cut them into small pieces.\n" +
                            "4. Stir the marinade with the cucumber segments and mix well for serving.")
            },
            {
                    // Noodles
                    new ProductBean("Fired Noodles", 47, R.drawable.noodles_fired_noodles,"【Material】\n" +
                            "Gherkin 600 grams\n" +
                            "Bruschetta 10 grams\n" +
                            "Salt 15 grams\n" +
                            "[seasoning]\n" +
                            "Pepper sauce 50 grams\n" +
                            "White soy sauce 2 tablespoons\n" +
                            "Salt\n" +
                            "Fine sugar 25 grams\n" +
                            "Water 150cc\n" +
                            "Sesame oil 1 tsp\n" +
                            "\n" +
                            "[doing]\n" +
                            "1. Wash the cucumbers and cut off the head and tail; add a uniform piece of salt and knead until soft.\n" +
                            "2. Put the gherkin of Practice 1 into a drainable basket and press the cucumber over with a heavy object to make it slowly out of water for about 1 day.\n" +
                            "3. Stir all the pickle sauces; remove the gherkins from recipe 3 and cut them into small pieces.\n" +
                            "4. Stir the marinade with the cucumber segments and mix well for serving."),
                    new ProductBean("Plain Noodles", 32, R.drawable.noodles_plain_noodles,"【Material】\n" +
                            "Gherkin 600 grams\n" +
                            "Bruschetta 10 grams\n" +
                            "Salt 15 grams\n" +
                            "[seasoning]\n" +
                            "Pepper sauce 50 grams\n" +
                            "White soy sauce 2 tablespoons\n" +
                            "Salt\n" +
                            "Fine sugar 25 grams\n" +
                            "Water 150cc\n" +
                            "Sesame oil 1 tsp\n" +
                            "\n" +
                            "[doing]\n" +
                            "1. Wash the cucumbers and cut off the head and tail; add a uniform piece of salt and knead until soft.\n" +
                            "2. Put the gherkin of Practice 1 into a drainable basket and press the cucumber over with a heavy object to make it slowly out of water for about 1 day.\n" +
                            "3. Stir all the pickle sauces; remove the gherkins from recipe 3 and cut them into small pieces.\n" +
                            "4. Stir the marinade with the cucumber segments and mix well for serving.")
            },
            {
                    // Desserts
                    new ProductBean("Coconut Tree Juice Sago dew", 25, R.drawable.desserts_coconut_tree_juice_sago_dew,"【Material】\n" +
                            "Gherkin 600 grams\n" +
                            "Bruschetta 10 grams\n" +
                            "Salt 15 grams\n" +
                            "[seasoning]\n" +
                            "Pepper sauce 50 grams\n" +
                            "White soy sauce 2 tablespoons\n" +
                            "Salt\n" +
                            "Fine sugar 25 grams\n" +
                            "Water 150cc\n" +
                            "Sesame oil 1 tsp\n" +
                            "\n" +
                            "[doing]\n" +
                            "1. Wash the cucumbers and cut off the head and tail; add a uniform piece of salt and knead until soft.\n" +
                            "2. Put the gherkin of Practice 1 into a drainable basket and press the cucumber over with a heavy object to make it slowly out of water for about 1 day.\n" +
                            "3. Stir all the pickle sauces; remove the gherkins from recipe 3 and cut them into small pieces.\n" +
                            "4. Stir the marinade with the cucumber segments and mix well for serving.")
            },
            {
                    // Drinks
                    new ProductBean("Green Tea", 14, R.drawable.drink_green_tea,"【Material】\n" +
                            "Gherkin 600 grams\n" +
                            "Bruschetta 10 grams\n" +
                            "Salt 15 grams\n" +
                            "[seasoning]\n" +
                            "Pepper sauce 50 grams\n" +
                            "White soy sauce 2 tablespoons\n" +
                            "Salt\n" +
                            "Fine sugar 25 grams\n" +
                            "Water 150cc\n" +
                            "Sesame oil 1 tsp\n" +
                            "\n" +
                            "[doing]\n" +
                            "1. Wash the cucumbers and cut off the head and tail; add a uniform piece of salt and knead until soft.\n" +
                            "2. Put the gherkin of Practice 1 into a drainable basket and press the cucumber over with a heavy object to make it slowly out of water for about 1 day.\n" +
                            "3. Stir all the pickle sauces; remove the gherkins from recipe 3 and cut them into small pieces.\n" +
                            "4. Stir the marinade with the cucumber segments and mix well for serving."),
                    new ProductBean("Black Tea", 12, R.drawable.drink_blank_tea,"【Material】\n" +
                            "Gherkin 600 grams\n" +
                            "Bruschetta 10 grams\n" +
                            "Salt 15 grams\n" +
                            "[seasoning]\n" +
                            "Pepper sauce 50 grams\n" +
                            "White soy sauce 2 tablespoons\n" +
                            "Salt\n" +
                            "Fine sugar 25 grams\n" +
                            "Water 150cc\n" +
                            "Sesame oil 1 tsp\n" +
                            "\n" +
                            "[doing]\n" +
                            "1. Wash the cucumbers and cut off the head and tail; add a uniform piece of salt and knead until soft.\n" +
                            "2. Put the gherkin of Practice 1 into a drainable basket and press the cucumber over with a heavy object to make it slowly out of water for about 1 day.\n" +
                            "3. Stir all the pickle sauces; remove the gherkins from recipe 3 and cut them into small pieces.\n" +
                            "4. Stir the marinade with the cucumber segments and mix well for serving.")
            },
            {
                    // Wine
                    new ProductBean("Red Wine", 86, R.drawable.wine_red_wine,"【Material】\n" +
                            "Gherkin 600 grams\n" +
                            "Bruschetta 10 grams\n" +
                            "Salt 15 grams\n" +
                            "[seasoning]\n" +
                            "Pepper sauce 50 grams\n" +
                            "White soy sauce 2 tablespoons\n" +
                            "Salt\n" +
                            "Fine sugar 25 grams\n" +
                            "Water 150cc\n" +
                            "Sesame oil 1 tsp\n" +
                            "\n" +
                            "[doing]\n" +
                            "1. Wash the cucumbers and cut off the head and tail; add a uniform piece of salt and knead until soft.\n" +
                            "2. Put the gherkin of Practice 1 into a drainable basket and press the cucumber over with a heavy object to make it slowly out of water for about 1 day.\n" +
                            "3. Stir all the pickle sauces; remove the gherkins from recipe 3 and cut them into small pieces.\n" +
                            "4. Stir the marinade with the cucumber segments and mix well for serving."),
                    new ProductBean("White Wine", 88, R.drawable.wine_white_wine,"【Material】\n" +
                            "Gherkin 600 grams\n" +
                            "Bruschetta 10 grams\n" +
                            "Salt 15 grams\n" +
                            "[seasoning]\n" +
                            "Pepper sauce 50 grams\n" +
                            "White soy sauce 2 tablespoons\n" +
                            "Salt\n" +
                            "Fine sugar 25 grams\n" +
                            "Water 150cc\n" +
                            "Sesame oil 1 tsp\n" +
                            "\n" +
                            "[doing]\n" +
                            "1. Wash the cucumbers and cut off the head and tail; add a uniform piece of salt and knead until soft.\n" +
                            "2. Put the gherkin of Practice 1 into a drainable basket and press the cucumber over with a heavy object to make it slowly out of water for about 1 day.\n" +
                            "3. Stir all the pickle sauces; remove the gherkins from recipe 3 and cut them into small pieces.\n" +
                            "4. Stir the marinade with the cucumber segments and mix well for serving.")
            }
    };
}
