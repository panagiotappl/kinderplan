/**
 * Created by Panos on 20/05/2017.
 */

router.controller('addEventController', function($scope, $cookies, FilesService, EventsService){

    $scope.credentials = {
        provider: '',
        eventName: '',
        ageFrom: '',
        ageTo: '',
        ticketPrice: '',
        description: '',
        latitude: '',
        longitude: '',
        address: '',
        startDate: null,
        endDate: null,
        dates: [],
        datesPicker: [{startDate: null, // TODO: Add today here
            endDate: null,  // TODO: And here
            availableTickets: 0
        }]
    };

    $scope.addNewDate = function() {
        $scope.credentials.datesPicker.push({startDate: null,
            endDate: null,
            availableTickets: 0
        });
    };

    $scope.removeDate = function() {
        var lastItem = $scope.credentials.datesPicker.length-1;
        $scope.credentials.datesPicker.splice(lastItem);
    };


    $scope.add = function(){
        var error = false;
        var miss_error = false;

        req = $scope.credentials;

        req.createdDate = new Date();
        req.address = $scope.geoloc;

        $scope.options = {
            types: 'geocode',
            watchEnter: true,
            country: 'gr'
        };

        if (error ||  miss_error) return;

        var address = $scope.details.geometry.location;

        req.latitude = address.lat();
        req.longitude = address.lng();

        var request = {
            name: req.eventName,
            address: req.address,
            latitude: req.latitude,
            longitude: req.longitude,
            age_from: req.ageFrom,
            age_to: req.ageTo,
            ticket_price: req.ticketPrice,
            description: req.description,
            date_ending: 1495965135222, // TODO: Get first date from dates
            date_starting: 1495965135222, //TODO: Get last date from dates
            categories:[
                {category: "sports"},
                {category: "team"}
            ],
            dates: []
            // ,
            // "dates":[
            //     {"start_date":"1495965135222",
            //         "end_date":"1495965135222",
            //         "available_tickets":"5",
            //         "tickets_sold":"2",
            //         "note":"oraia mera"
            //     },
            //     {"start_date":"1495965135222",
            //         "end_date":"1495965135222",
            //         "available_tickets":"5",
            //         "tickets_sold":"2",
            //         "note":"asximi mera"
            //     }
            // ]
        };



        req.datesPicker.forEach( function (date)
        {
            var startDate = new Date(date.startDate._d);
            var endDate = new Date(date.endDate._d);

            request.dates.push({
                start_date: startDate.getTime(),
                end_date: endDate.getTime(),
                available_tickets: date.availableTickets
            });
        });


        console.log(request);
        EventsService.submitEvent(request, $cookies.get('authToken'))
            .then(function(response){
                console.log(response);
                // $state.go('home');

            }, function(error){
                $scope.error_message = error.data.message;
                console.log($scope.error_message);

            });


    };


    $scope.files = [];
    $scope.upload= function(){
        var files = $scope.files;
        console.log(files);

        var fileCount = files.length;

        for (var i = 0; i < fileCount; i++) {

            FilesService.upload_file(files[i])
                .then(function (response){
                    console.log(response);
                    $scope.credentials.photos.push(response.data.path);
                });

        }

    };

});

