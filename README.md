# ecommerce
This is the demo e-commerce application developed using spring boot,postgress and MVC design pattern.
This will do basic order placement (single and bulk) and crud operations for the product using various functions
APIs and their functionalities
1.Get All Order Details
  Request Method = GET
  Request URL =/ecommerce/get-all-orders
  public ResponseEntity<List<OrderDto>> getAllOrders()
  returns = List of Order Details
  HTTP status code = 200
  
2.Get All Product Details
  Request Method = GET
  Request URL = /ecommerce/get-all-products
  public ResponseEntity<List<ProductDto>> getAllProducts()
  returns = List of product Details
  HTTP status code = 200
  
 3.Particular user Order Details
  Request Method = GET
  Request URL = /ecommerce/get-all-orders
  Request Parm = emailId
  public ResponseEntity<List<OrderDto>> viewOrderDetails(@RequestParam("emailId") String emailId) 
  returns = List of particular user details
  HTTP status code = 200
  
 4.Get Particular product details
  Request Method = GET
  Request URL = /ecommerce/get-product
  public ResponseEntity<ProductDto> getPrdouctDetailsById(@RequestParam("id") Long id)
  returns = Product Details
  HTTP status code = 200
  
5.Cancel Order Details
 Request Method = GET
 Request URL = /ecommerce/cancel-order
 public ResponseEntity<String> cancelOrder(@RequestParam("id") Long id)
 returns = order status
 HTTP status code = 200
  
6.Remove Product 
 Request Method = GET
 Request URL = /ecommerce/remove-product
 public ResponseEntity<String> removeProduct(@RequestParam("id") Long id)
 returns = product status
 HTTP status code = 200
  
7.Add and Update Product Details
 Request Method = POST
 Request URL = /ecommerce/add-product
 Request Body = ProductDTO
 public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto)
 returns = added and updated product details
 HTTP status code = 200
  
 8.Place Order
  Request Method = POST
  Request URL = /ecommerce/place-order
  Request Body = OrderDTO
  public ResponseEntity<ProductDto> placeOrder(@RequestBody OrderDto orderDto)
  returns = Order Placement
  HTTP status code = 200
