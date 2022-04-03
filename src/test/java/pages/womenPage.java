package pages;

import driver.Driver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class womenPage {

	public womenPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	public final String sortByAtoZ = "Product Name: A to Z";

	public final String sortByZtoA = "Product Name: Z to A";

	public final String sortByPriceLowestFirst = "Price: Lowest first";

	public final String sortByInStock = "In stock";

	@FindBy(xpath = "//*[@id='categories_block_left']/div/ul/li[2]/a")
	public WebElement dressLink;

	@FindBy(xpath = "//select[@id='selectProductSort']")
	public WebElement selectSortBy;

	@FindBy(xpath = "//ul[@class='product_list grid row']/descendant::a[@class='product-name']")
	public List<WebElement> productNameList;

	@FindBy(xpath = "//div[@class='right-block']/div/span[@class='price product-price']")
	public List<WebElement> productPriceList;

	@FindBy(xpath = "//*[@class='right-block']")
	public List<WebElement> productContainerList;

	public double extractDoubleFromString(String str) {
		String temp = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
				temp += str.charAt(i);
			} else if (str.charAt(i) == 46) {
				temp += str.charAt(i);
			}
		}
		double result = Double.parseDouble(temp);
		return result;
	}

	public void verifyItemSortedAtoZ() {

		ArrayList<String> productList = new ArrayList<String>();
		for (int i = 0; i < productNameList.size(); i++) {
			String name = productNameList.get(i).getText().trim();
//			System.out.println("A to Z: "+name);
			productList.add(name);
		}

		for (int i = 0; i < productList.size(); i++) {

			if (i + 1 < productList.size()) {

				if (productList.get(i).length() <= productList.get(i + 1).length()) {

					for (int j = 0; j < productList.get(i).length(); j++) {
						if (productList.get(i).charAt(j) < productList.get(i + 1).charAt(j)) {
							Assert.assertTrue(productList.get(i).charAt(j) < productList.get(i + 1).charAt(j));
							break;
						}

					}
				} else if (productList.get(i).length() > productList.get(i + 1).length()) {
					for (int j = 0; j < productList.get(i + 1).length(); j++) {
						if (productList.get(i).charAt(j) < productList.get(i + 1).charAt(j)) {
							Assert.assertTrue(productList.get(i).charAt(j) < productList.get(i + 1).charAt(j));
							break;
						}
					}
				}

			}

		}
	}

	public void verifyItemSortedZtoA() {

		ArrayList<String> productList = new ArrayList<String>();
		for (int i = 0; i < productNameList.size(); i++) {
			String name = productNameList.get(i).getText().trim();
//			System.out.println("Z to A: "+name);
			productList.add(name);
		}

		for (int i = 0; i < productList.size(); i++) {

			if (i + 1 < productList.size()) {

				if (productList.get(i).length() <= productList.get(i + 1).length()) {

					for (int j = 0; j < productList.get(i).length(); j++) {
						if (productList.get(i).charAt(j) > productList.get(i + 1).charAt(j)) {
							Assert.assertTrue(productList.get(i).charAt(j) > productList.get(i + 1).charAt(j));
							break;
						}

					}
				} else if (productList.get(i).length() > productList.get(i + 1).length()) {
					for (int j = 0; j < productList.get(i + 1).length(); j++) {
						if (productList.get(i).charAt(j) > productList.get(i + 1).charAt(j)) {
							Assert.assertTrue(productList.get(i).charAt(j) > productList.get(i + 1).charAt(j));
							break;
						}
					}
				}

			}

		}
	}

	public void verifyItemSortedLowestFirst() {
		ArrayList<Double> list = new ArrayList<Double>();

		for (int i = 0; i < productPriceList.size(); i++) {
			double price = extractDoubleFromString(productPriceList.get(i).getText());
			list.add(price);
			list.set(i, price);

		}
//		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			if (i + 1 < list.size()) {
				if (list.get(i) < list.get(i + 1)) {
					Assert.assertTrue(list.get(i) < list.get(i + 1));
				}
			}

//			System.out.println("last one: "+list.get(list.size()-1));
//			System.out.println("Current: "+list.get(i));
			Assert.assertTrue(list.get(i) <= list.get(list.size() - 1));
		}
	}

	public void verifyItemSortedInStock() {
		ArrayList<WebElement> inStockItem = new ArrayList<WebElement>();
		for(WebElement item : productContainerList) {
			if(item.getText().contains(sortByInStock)) {
				inStockItem.add(item);
			}
		}
		
		Assert.assertEquals(productContainerList.size(), inStockItem.size());
	}



}
