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
            data: {pageTitle : ""}
        })
        .state('providerSignup', {
            url: '/signup/provider',
            templateUrl: 'app/components/signup/provider_signup.html',
            controller: 'providerSignupController',
            data: {pageTitle : "Signup - Provider"}
        })
        .state('parentSignup', {
            url: '/signup/parent',
            templateUrl: 'app/components/signup/parent_signup.html',
            controller: 'parentSignupController',
            data: {pageTitle : "Signup - Parent"}
        })
        .state('signup', {
            url: '/signup',
            templateUrl: 'app/components/signup/signup.html',
            controller: 'signupController',
            data: {pageTitle : "Sign Up"}
        })
        .state('addEvent', {
            url: '/events/add',
            templateUrl: 'app/components/events/add_event.html',
            controller: 'addEventController',
            data: {pageTitle : "Add event"}
        });
});