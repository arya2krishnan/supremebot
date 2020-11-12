const xhr = new XMLHttpRequest();
xhr.open("POST", "https://www.supremenewyork.com/shop/173113/add.json", true);
xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
xhr.setRequestHeader("user-agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1");
const data = "s=77261&st=26837&qty=1";
xhr.send(data);