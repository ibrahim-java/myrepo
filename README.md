# AvailableHotelApi

This project is a sample project to demonestrate how can we have different Thirdparties (HotelProvider) and will search in all these providers to get the availabe hotel. it shows that there is Internal parameters and how we mapped these parameters to HotelProviders and prepare Request to and Response from it.

Main URL: http://localhost:8080/availablehotel/search , POST

Sample Request:

{
	"fromDate" : "2019-02-21",
	"toDate" : "2019-02-24",
	"city" : "AUH",
	"numberOfAdults" : 2
}


Sample Response:

[{
		"provider": "CrazyHotel",
		"hotelName": "Hotel1",
		"fare": 30,
		"amenities": [
			"F1",
			"F2",
			"F3",
			"F4"
		],
		"discount": 0
	},
	{
		"provider": "BestHotel",
		"hotelName": "Hotel2",
		"fare": 70.9,
		"amenities": [
			"F1",
			" F2",
			" F3",
			" F4",
			" F5"
		]
	}
]

Providers URLS:
1. http://localhost:8080/besthotel , GET
2. http://localhost:8080/crazyhotel , GET

Providers Sample Response:

{
	"hotelName": "Hotel1",
	"rate": "****",
	"price": 30.0,
	"discount": 0,
	"amenities": ["F1", "F2", "F3", "F4"]
}

{
	"hotel": "Hotel2",
	"hotelRate": 3,
	"hotelFare": 70.9,
	"roomAmenities": "F1, F2, F3, F4, F5"
}
