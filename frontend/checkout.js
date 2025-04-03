var cartItems = [];
var cartTotal = 0;
var totalPrice = 0;

document.getElementById('addItemBtn').addEventListener('click', function(event) {
    event.preventDefault();

    var productName = document.getElementById('product').value;
    var quantity = document.getElementById('Quantity').value;

    var data = JSON.stringify({
        "name": productName,
        "quantity": quantity
    });

    var xhr = new XMLHttpRequest();
    // var url = "http://localhost:8080/login"; // 后端服务器的URL
    var url = "http://localhost:8080/Checkout/addItem"; // 后端服务器的URL

    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                var json = JSON.parse(xhr.responseText);
                console.log(json);
                
                // Update our cart data with the new data from server
                cartItems = json.cartItems;
                cartTotal = json.total;
                totalPrice += cartTotal;
                // Update the display
                updateCart(cartItems, cartTotal);
                
                // Clear the input fields for next item
                document.getElementById('product').value = '';
                document.getElementById('Quantity').value = '';
            } else {
                alert("You Catch a Bug!! " + xhr.status);
            }
        }
    };
    xhr.send(data);
});

function updateCart(cartItems, total) {
    var cartTableBody = document.getElementById("cartTable").getElementsByTagName("tbody")[0];
    // cartTableBody.innerHTML = ''; // Clear existing items

    cartItems.forEach(function(item) {
        var row = cartTableBody.insertRow();
        row.insertCell(0).textContent = item.product.name;
        row.insertCell(1).textContent = item.product.price;
        row.insertCell(2).textContent = item.quantity;
        row.insertCell(3).textContent = item.product.price * item.quantity;
    });

    // Update total price
    document.getElementById("totalPrice").textContent = totalPrice;
}
