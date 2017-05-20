/**
 * Created by Panos on 20/05/2017.
 */

'use strict';

router.config(function($stateProvider, $urlRouterProvider, $compileProvider) {

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
        });
});