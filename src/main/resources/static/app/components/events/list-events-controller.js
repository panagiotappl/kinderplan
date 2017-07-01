/**
 * Created by Panos on 10/06/2017.
 */


router.controller('listEventsController', function($scope, $cookies, $stateParams, EventsService) {

    EventsService.search($stateParams.query)
        .then( function (response){
            console.log(response);
        }, function(response){
            console.log(response);
        });

    $scope.events = [{name: "PlayGround", description: "Ennoies twn ergwn, sxediasmos, Xronikos programmatismos, ergaleia, texnikes kai methodologia"},
        {name: "Kinderkarden", description: "I'm a puppet on a string, tracy island, time travelling diamong cutted shaped heart aches"}];


});