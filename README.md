# restapispringboot
spring boot rest example
:spring_version: current
:toc:
:project_id: gs-rest-service
:spring_version: current
:spring_boot_version: 2.0.5.RELEASE
:icons: font
:source-highlighter: prettify

This guide walks you through the process of creating a "discount value" 
Mandatory Record
1	 Discount.csv in d drive i.e d:\\Discount.csv



== What you'll build

You'll build a service that will accept HTTP GET requests at:

----
http://localhost:8080/discount?userType=Standard&amount=2500
----

and respond with a link:/understanding/JSON[JSON] representation of a discount:

[source,json]
----
{"2350.0"}
----

You can customize the discount with an require userType,amount parameter in the query string:

----
http://localhost:8080/greeting?userType=Standard&amount=2500
----

The userType and amount parameter value require in the response:

[source,json]
----
{2350.0}
----




== Create a resource controller

In Spring's approach to building RESTful web services, HTTP requests are handled by a controller. These components are easily identified by the and the `DiscountController` below handles `GET` requests for `/discount` by returning a new instance of the `DiscountService` class:

`src/main/java/com/flightnetwork/main/DiscountController.java`
[source,java]
'src/main/java/com/flightnetwork/main/Application.java`
[source,java]
`src/main/java/com/flightnetwork/main/CorsFilter.java`
[source,java]
'src/main/java/com/flightnetwork/demo/api/APIName.java`
[source,java]
'src/main/java/com/flightnetwork/demo/api/response/model/APIResponse.java`
[source,java]
'src/main/java/com/flightnetwork/demo/api/response/model/StatusResponse.java`
[source,java]
'src/main/java/com/flightnetwork/demo/api/response/util/APIStatus.java`
[source,java]
'src/main/java/com/flightnetwork/demo/api/response/util/ResponseUtil.java`
[source,java]
'src/main/java/com/flightnetwork/demo/exception/ApplicationException.java`
[source,java]
'src/main/java/com/flightnetwork/demo/service/DiscountService.java`
[source,java]
'src/main/java/com/flightnetwork/demo/util/Constant.java`
[source,java]
----


This controller is concise and simple, but there's plenty going on under the hood. Let's break it down step by step.

The `@RequestMapping` annotation ensures that HTTP requests to `/discount` are mapped to the `greeting()` method.

NOTE: The above example does not specify `GET` vs. `PUT`, `POST`, and so forth, because `@RequestMapping` maps all HTTP operations by default. Use `@RequestMapping(method=GET)` to narrow this mapping.

`@RequestParam` binds the value of the query string parameter `userType`,'amount' into the `userType`,'amount' parameter of the `greeting()` method. Parameter userType , amount both r require

The implementation of the method body creates and returns a new `Greeting` object with discount amount

A key difference between a traditional MVC controller and the RESTful web service controller above is the way that the HTTP response body is created. Rather than relying on a link:/understanding/view-templates[view technology] to perform server-side rendering of the greeting data to HTML, this RESTful web service controller simply populates and returns a `String` object. The object data will be written directly to the HTTP response as JSON.




