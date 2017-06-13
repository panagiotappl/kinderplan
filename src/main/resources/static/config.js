/**
 * Created by Panos on 20/05/2017.
 */

'use strict';

router.config(function($stateProvider, $urlRouterProvider, $mdThemingProvider, $compileProvider) {
    $mdThemingProvider.theme('default')
        .primaryPalette('teal')
        .accentPalette('deep-orange');
    $urlRouterProvider.otherwise('/');

    $stateProvider

        .state('home', {
            url: '/',
            templateUrl: 'app/components/homepage/homepage.html',
            controller: 'homepageController',
            data: {pageTitle : "Kinderplan"}
        })
        .state('providerSignup', {
            url: '/signup/provider',
            templateUrl: 'app/components/signup/provider_signup.html',
            controller: 'providerSignupController',
            data: {pageTitle : "Provider Sign Up"}

        })
        .state('parentSignup', {
            url: '/signup/parent',
            templateUrl: 'app/components/signup/parent_signup.html',
            controller: 'parentSignupController',
            data: {pageTitle : "Parent Sign Up"}
        })
        .state('signup', {
            url: '/signup',
            templateUrl: 'app/components/signup/signup.html',
            controller: 'signupController',
            data: {pageTitle : "Sign Up"}
        })
        .state('addEvent', {
            url: '/event/add',
            templateUrl: 'app/components/events/add_event.html',
            controller: 'addEventController',
            data: {pageTitle : "Add event"}
        })
        .state('event', {
            url: '/event?id',
            templateUrl: 'app/components/events/event.html',
            controller: 'eventController',
            data: {pageTitle : ""}
        })
        .state('listEvents', {
            url: '/events/list',
            templateUrl: 'app/components/events/list_events.html',
            controller: 'listEventsController',
            data: {pageTitle : "Events"}
        });
});