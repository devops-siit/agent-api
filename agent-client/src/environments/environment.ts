// This file can be replaced during build by using the `fileReplacements` array.
// `ng build` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  baseUrl: 'http://localhost:8080',
  authUrl: 'http://localhost:8181',
  login: 'login',
  signUp: 'register',
  signOut: 'sign-out',
  changePassword: 'auth/change-password',
  agentUrl: 'http://localhost:8087/agent',
  
  companyReq: 'http://localhost:8087/company-request',
  rate:'http://localhost:8087/rates',
  comment: 'http://localhost:8087/company-comment',
  user: 'api/user',
  offerUrl:'http://localhost:8087/offers',
  company: 'http://localhost:8087/companies'
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.
