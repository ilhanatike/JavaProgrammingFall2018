package Mentoring;

import java.util.ArrayList;
import java.util.List;

public class Chrome extends Browser {
	
	/**
	 * Create constructor for Chrome that takes integer(memory). Set the given
memory to browsers instance variable memory. Next, instantiate List of Url
instance.
	 */

	public Chrome(int memory) {
		this.memory=memory;
		this.urls=new ArrayList();
	}
	/**
	 * Override launchBrowser method. You should check if browser was launched
before. If browser is launched already then print �Chrome browser is
already launched�, else print �Chrome browser is launching�. Also
decrement memory by 50 and set browserLaunched variable to �true�.
	 */
	@Override
	public void launchBrowser() {
		if(this.browserLaunched) {
			System.out.println("Chrome browser is already launched");
			
		}else {
			System.out.println("Chrome browser is launching");
			this.memory-=50;
			this.browserLaunched=true;
		}
		
	}
	
	/**
	 * Override addTab method. First, you need to check if browser was launched
already(use browserLaunched variable as reference). If launched then
check if memory has at least 25 MB. If Browser was launched and has at
least 25 MB memory then print �Chrome browser adding new tab:
%givenURL�. Add URL to list of urls, update focusedUrl to given URL,
decrement 25 from memory. If browser was launched but doesn�t have
enough memory then print �Sorry Chrome browser is out of memory�. If
browser was not launched then print �Chrome browser is not launched yet.
Please launch the browser first.�
	 */
	@Override
	public void addTab(String url) {
		if(this.browserLaunched) {
			if(this.memory>=25) {
				System.out.println("Chrome browser adding new tab: "+url);
				urls.add(url);
				this.focusedUrl=url;
				this.memory-=25;
			}else {
			System.out.println("Sorry chrome browser is out of memory");}
		}else {
			System.out.println("Chrome browser is not launched yet. Please launch the browser first");
		}
	}
	
	/**
	 * Override closeTab. Iterate thought each urls and find matching url. Once url is
found, remove the url from List of Urls, add 25 MB to memory, print �Tab
with: %url is closed� and return true; If given URL if not found in List of
Urls then print �Tab with: %url was not found within open tabs� and
return false;
	 */
	@Override
	public boolean closeTab(String url) {
		for(String eachUrl:this.urls) {
			if(eachUrl.equals(url)) {
				urls.remove(eachUrl);
				this.memory+=25;
				System.out.println("Tab with: "+url+" is closed");
				return true;
			}
				
				
			
		
		}
		System.out.println("Tab with: "+url+" was not found within open tabs");
		return false;
		
		
	}
	@Override
	public void changeTab(String url) {
		// TODO Auto-generated method stub
		for(String eachUrl:this.urls) {
			if(eachUrl.equals(url)) {
				this.focusedUrl=url;
				System.out.println("Tab changed to URL: "+url);
				return;
			}
		}System.out.println("URL: " + url + " was not found within open tabs");
		
		
	}
	
	
	/**
	 * Override changeTab. Iterate through each urls and find matching url. Once url is
found, that focusedUrl to given url, print �Tab changed to URL: %url� and
terminate the method. If given URL is not found within tabs then print
�URL: %url was not found within open tabs�.
	 */
/**
 * Override closeBrowser. This method check if browser is already launched(use
browserLaunched variable as reference). If launched then print�Closing
Chrome browser. All tabs are closing�. And backup all the memory from
open tabs(increate memory by 25 MB for each open tab and 50 MB for
laughed browser). Clear List of url, set null to focusedUrl, set false to
browserLaunched variable. If browser was not launched then
print�Chrome browser was not launched�.
 */
	@Override
	public void closeBrowser() {
		// TODO Auto-generated method stub
		if(this.browserLaunched) {
			System.out.println("Closing Chrome browser. All tabs are closing. ");
			this.memory+=(this.urls.size()*25)+50;
			this.urls.clear();
			this.focusedUrl=null;
		}else {
			System.out.println("Chrome browser was not launched");
		}
		
	}
}
