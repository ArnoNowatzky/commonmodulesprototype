(function () {
  function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

  function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

  function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"], {
    /***/
    0:
    /*!***************************!*\
      !*** multi ./src/main.ts ***!
      \***************************/

    /*! no static exports found */

    /***/
    function _(module, exports, __webpack_require__) {
      module.exports = __webpack_require__(
      /*! /Users/OleyMa/vcs/wawiNeu/commonmodulesprototype/commonModuleUi/src/main.ts */
      "zUnb");
      /***/
    },

    /***/
    "5Ajo":
    /*!**************************************!*\
      !*** ./src/app/generated/api/api.ts ***!
      \**************************************/

    /*! exports provided: CustomerService, APIS */

    /***/
    function Ajo(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "APIS", function () {
        return APIS;
      });
      /* harmony import */


      var _customer_service__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! ./customer.service */
      "8B3j");
      /* harmony reexport (safe) */


      __webpack_require__.d(__webpack_exports__, "CustomerService", function () {
        return _customer_service__WEBPACK_IMPORTED_MODULE_0__["CustomerService"];
      });

      var APIS = [_customer_service__WEBPACK_IMPORTED_MODULE_0__["CustomerService"]];
      /***/
    },

    /***/
    "81EJ":
    /*!************************************!*\
      !*** ./src/app/generated/index.ts ***!
      \************************************/

    /*! exports provided: CustomerService, APIS, BASE_PATH, COLLECTION_FORMATS, Configuration, ApiModule */

    /***/
    function EJ(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony import */


      var _api_api__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! ./api/api */
      "5Ajo");
      /* harmony reexport (safe) */


      __webpack_require__.d(__webpack_exports__, "CustomerService", function () {
        return _api_api__WEBPACK_IMPORTED_MODULE_0__["CustomerService"];
      });
      /* harmony reexport (safe) */


      __webpack_require__.d(__webpack_exports__, "APIS", function () {
        return _api_api__WEBPACK_IMPORTED_MODULE_0__["APIS"];
      });
      /* harmony import */


      var _model_models__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! ./model/models */
      "u36I");
      /* empty/unused harmony star reexport */

      /* harmony import */


      var _variables__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! ./variables */
      "vSC0");
      /* harmony reexport (safe) */


      __webpack_require__.d(__webpack_exports__, "BASE_PATH", function () {
        return _variables__WEBPACK_IMPORTED_MODULE_2__["BASE_PATH"];
      });
      /* harmony reexport (safe) */


      __webpack_require__.d(__webpack_exports__, "COLLECTION_FORMATS", function () {
        return _variables__WEBPACK_IMPORTED_MODULE_2__["COLLECTION_FORMATS"];
      });
      /* harmony import */


      var _configuration__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! ./configuration */
      "CduQ");
      /* harmony reexport (safe) */


      __webpack_require__.d(__webpack_exports__, "Configuration", function () {
        return _configuration__WEBPACK_IMPORTED_MODULE_3__["Configuration"];
      });
      /* harmony import */


      var _api_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
      /*! ./api.module */
      "Lxev");
      /* harmony reexport (safe) */


      __webpack_require__.d(__webpack_exports__, "ApiModule", function () {
        return _api_module__WEBPACK_IMPORTED_MODULE_4__["ApiModule"];
      });
      /***/

    },

    /***/
    "8B3j":
    /*!***************************************************!*\
      !*** ./src/app/generated/api/customer.service.ts ***!
      \***************************************************/

    /*! exports provided: CustomerService */

    /***/
    function B3j(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "CustomerService", function () {
        return CustomerService;
      });
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! @angular/common/http */
      "tk/3");
      /* harmony import */


      var _encoder__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! ../encoder */
      "jTWb");
      /* harmony import */


      var _variables__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! ../variables */
      "vSC0");
      /* harmony import */


      var _configuration__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
      /*! ../configuration */
      "CduQ");
      /**
       * customer api
       * API of service example customer
       *
       * The version of the OpenAPI document: 1.0.0
       *
       *
       * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
       * https://openapi-generator.tech
       * Do not edit the class manually.
       */

      /* tslint:disable:no-unused-variable member-ordering */


      var CustomerService = /*#__PURE__*/function () {
        function CustomerService(httpClient, basePath, configuration) {
          _classCallCheck(this, CustomerService);

          this.httpClient = httpClient;
          this.basePath = 'http://localhost:8002';
          this.defaultHeaders = new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]();
          this.configuration = new _configuration__WEBPACK_IMPORTED_MODULE_4__["Configuration"]();

          if (configuration) {
            this.configuration = configuration;
          }

          if (typeof this.configuration.basePath !== 'string') {
            if (typeof basePath !== 'string') {
              basePath = this.basePath;
            }

            this.configuration.basePath = basePath;
          }

          this.encoder = this.configuration.encoder || new _encoder__WEBPACK_IMPORTED_MODULE_2__["CustomHttpParameterCodec"]();
        }

        _createClass(CustomerService, [{
          key: "addToHttpParams",
          value: function addToHttpParams(httpParams, value, key) {
            if (typeof value === "object" && value instanceof Date === false) {
              httpParams = this.addToHttpParamsRecursive(httpParams, value);
            } else {
              httpParams = this.addToHttpParamsRecursive(httpParams, value, key);
            }

            return httpParams;
          }
        }, {
          key: "addToHttpParamsRecursive",
          value: function addToHttpParamsRecursive(httpParams, value, key) {
            var _this = this;

            if (value == null) {
              return httpParams;
            }

            if (typeof value === "object") {
              if (Array.isArray(value)) {
                value.forEach(function (elem) {
                  return httpParams = _this.addToHttpParamsRecursive(httpParams, elem, key);
                });
              } else if (value instanceof Date) {
                if (key != null) {
                  httpParams = httpParams.append(key, value.toISOString().substr(0, 10));
                } else {
                  throw Error("key may not be null if value is Date");
                }
              } else {
                Object.keys(value).forEach(function (k) {
                  return httpParams = _this.addToHttpParamsRecursive(httpParams, value[k], key != null ? "".concat(key, ".").concat(k) : k);
                });
              }
            } else if (key != null) {
              httpParams = httpParams.append(key, value);
            } else {
              throw Error("key may not be null if value is not object or array");
            }

            return httpParams;
          }
        }, {
          key: "getCustomer",
          value: function getCustomer(customerId) {
            var observe = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : 'body';
            var reportProgress = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : false;
            var options = arguments.length > 3 ? arguments[3] : undefined;

            if (customerId === null || customerId === undefined) {
              throw new Error('Required parameter customerId was null or undefined when calling getCustomer.');
            }

            var headers = this.defaultHeaders;
            var httpHeaderAcceptSelected = options && options.httpHeaderAccept;

            if (httpHeaderAcceptSelected === undefined) {
              // to determine the Accept header
              var httpHeaderAccepts = ['application/json'];
              httpHeaderAcceptSelected = this.configuration.selectHeaderAccept(httpHeaderAccepts);
            }

            if (httpHeaderAcceptSelected !== undefined) {
              headers = headers.set('Accept', httpHeaderAcceptSelected);
            }

            var responseType = 'json';

            if (httpHeaderAcceptSelected && httpHeaderAcceptSelected.startsWith('text')) {
              responseType = 'text';
            }

            return this.httpClient.get("".concat(this.configuration.basePath, "/customer/").concat(encodeURIComponent(String(customerId))), {
              responseType: responseType,
              withCredentials: this.configuration.withCredentials,
              headers: headers,
              observe: observe,
              reportProgress: reportProgress
            });
          }
        }, {
          key: "getCustomers",
          value: function getCustomers() {
            var observe = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : 'body';
            var reportProgress = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : false;
            var options = arguments.length > 2 ? arguments[2] : undefined;
            var headers = this.defaultHeaders;
            var httpHeaderAcceptSelected = options && options.httpHeaderAccept;

            if (httpHeaderAcceptSelected === undefined) {
              // to determine the Accept header
              var httpHeaderAccepts = ['application/json'];
              httpHeaderAcceptSelected = this.configuration.selectHeaderAccept(httpHeaderAccepts);
            }

            if (httpHeaderAcceptSelected !== undefined) {
              headers = headers.set('Accept', httpHeaderAcceptSelected);
            }

            var responseType = 'json';

            if (httpHeaderAcceptSelected && httpHeaderAcceptSelected.startsWith('text')) {
              responseType = 'text';
            }

            return this.httpClient.get("".concat(this.configuration.basePath, "/customer/findAll"), {
              responseType: responseType,
              withCredentials: this.configuration.withCredentials,
              headers: headers,
              observe: observe,
              reportProgress: reportProgress
            });
          }
        }, {
          key: "setCustomer",
          value: function setCustomer(customerDTO) {
            var observe = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : 'body';
            var reportProgress = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : false;
            var options = arguments.length > 3 ? arguments[3] : undefined;

            if (customerDTO === null || customerDTO === undefined) {
              throw new Error('Required parameter customerDTO was null or undefined when calling setCustomer.');
            }

            var headers = this.defaultHeaders;
            var httpHeaderAcceptSelected = options && options.httpHeaderAccept;

            if (httpHeaderAcceptSelected === undefined) {
              // to determine the Accept header
              var httpHeaderAccepts = [];
              httpHeaderAcceptSelected = this.configuration.selectHeaderAccept(httpHeaderAccepts);
            }

            if (httpHeaderAcceptSelected !== undefined) {
              headers = headers.set('Accept', httpHeaderAcceptSelected);
            } // to determine the Content-Type header


            var consumes = ['application/json'];
            var httpContentTypeSelected = this.configuration.selectHeaderContentType(consumes);

            if (httpContentTypeSelected !== undefined) {
              headers = headers.set('Content-Type', httpContentTypeSelected);
            }

            var responseType = 'json';

            if (httpHeaderAcceptSelected && httpHeaderAcceptSelected.startsWith('text')) {
              responseType = 'text';
            }

            return this.httpClient.put("".concat(this.configuration.basePath, "/customer"), customerDTO, {
              responseType: responseType,
              withCredentials: this.configuration.withCredentials,
              headers: headers,
              observe: observe,
              reportProgress: reportProgress
            });
          }
        }]);

        return CustomerService;
      }();

      CustomerService.ɵfac = function CustomerService_Factory(t) {
        return new (t || CustomerService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_variables__WEBPACK_IMPORTED_MODULE_3__["BASE_PATH"], 8), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_configuration__WEBPACK_IMPORTED_MODULE_4__["Configuration"], 8));
      };

      CustomerService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({
        token: CustomerService,
        factory: CustomerService.ɵfac,
        providedIn: 'root'
      });
      /*@__PURE__*/

      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CustomerService, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
          args: [{
            providedIn: 'root'
          }]
        }], function () {
          return [{
            type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"],
              args: [_variables__WEBPACK_IMPORTED_MODULE_3__["BASE_PATH"]]
            }]
          }, {
            type: _configuration__WEBPACK_IMPORTED_MODULE_4__["Configuration"],
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
            }]
          }];
        }, null);
      })();
      /***/

    },

    /***/
    "AytR":
    /*!*****************************************!*\
      !*** ./src/environments/environment.ts ***!
      \*****************************************/

    /*! exports provided: environment */

    /***/
    function AytR(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "environment", function () {
        return environment;
      }); // This file can be replaced during build by using the `fileReplacements` array.
      // `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
      // The list of file replacements can be found in `angular.json`.


      var environment = {
        production: false,
        API_BASE_PATH: "http://localhost:8003"
      };
      /*
       * For easier debugging in development mode, you can import the following file
       * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
       *
       * This import should be commented out in production mode because it will have a negative impact
       * on performance if an error is thrown.
       */
      // import 'zone.js/dist/zone-error';  // Included with Angular CLI.

      /***/
    },

    /***/
    "CduQ":
    /*!********************************************!*\
      !*** ./src/app/generated/configuration.ts ***!
      \********************************************/

    /*! exports provided: Configuration */

    /***/
    function CduQ(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "Configuration", function () {
        return Configuration;
      });

      var Configuration = /*#__PURE__*/function () {
        function Configuration() {
          var configurationParameters = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : {};

          _classCallCheck(this, Configuration);

          this.apiKeys = configurationParameters.apiKeys;
          this.username = configurationParameters.username;
          this.password = configurationParameters.password;
          this.accessToken = configurationParameters.accessToken;
          this.basePath = configurationParameters.basePath;
          this.withCredentials = configurationParameters.withCredentials;
          this.encoder = configurationParameters.encoder;
        }
        /**
         * Select the correct content-type to use for a request.
         * Uses {@link Configuration#isJsonMime} to determine the correct content-type.
         * If no content type is found return the first found type if the contentTypes is not empty
         * @param contentTypes - the array of content types that are available for selection
         * @returns the selected content-type or <code>undefined</code> if no selection could be made.
         */


        _createClass(Configuration, [{
          key: "selectHeaderContentType",
          value: function selectHeaderContentType(contentTypes) {
            var _this2 = this;

            if (contentTypes.length === 0) {
              return undefined;
            }

            var type = contentTypes.find(function (x) {
              return _this2.isJsonMime(x);
            });

            if (type === undefined) {
              return contentTypes[0];
            }

            return type;
          }
          /**
           * Select the correct accept content-type to use for a request.
           * Uses {@link Configuration#isJsonMime} to determine the correct accept content-type.
           * If no content type is found return the first found type if the contentTypes is not empty
           * @param accepts - the array of content types that are available for selection.
           * @returns the selected content-type or <code>undefined</code> if no selection could be made.
           */

        }, {
          key: "selectHeaderAccept",
          value: function selectHeaderAccept(accepts) {
            var _this3 = this;

            if (accepts.length === 0) {
              return undefined;
            }

            var type = accepts.find(function (x) {
              return _this3.isJsonMime(x);
            });

            if (type === undefined) {
              return accepts[0];
            }

            return type;
          }
          /**
           * Check if the given MIME is a JSON MIME.
           * JSON MIME examples:
           *   application/json
           *   application/json; charset=UTF8
           *   APPLICATION/JSON
           *   application/vnd.company+json
           * @param mime - MIME (Multipurpose Internet Mail Extensions)
           * @return True if the given MIME is JSON, false otherwise.
           */

        }, {
          key: "isJsonMime",
          value: function isJsonMime(mime) {
            var jsonMime = new RegExp('^(application\/json|[^;/ \t]+\/[^;/ \t]+[+]json)[ \t]*(;.*)?$', 'i');
            return mime !== null && (jsonMime.test(mime) || mime.toLowerCase() === 'application/json-patch+json');
          }
        }]);

        return Configuration;
      }();
      /***/

    },

    /***/
    "Lxev":
    /*!*****************************************!*\
      !*** ./src/app/generated/api.module.ts ***!
      \*****************************************/

    /*! exports provided: ApiModule */

    /***/
    function Lxev(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "ApiModule", function () {
        return ApiModule;
      });
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var _configuration__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! ./configuration */
      "CduQ");
      /* harmony import */


      var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! @angular/common/http */
      "tk/3");

      var ApiModule = /*#__PURE__*/function () {
        function ApiModule(parentModule, http) {
          _classCallCheck(this, ApiModule);

          if (parentModule) {
            throw new Error('ApiModule is already loaded. Import in your base AppModule only.');
          }

          if (!http) {
            throw new Error('You need to import the HttpClientModule in your AppModule! \n' + 'See also https://github.com/angular/angular/issues/20575');
          }
        }

        _createClass(ApiModule, null, [{
          key: "forRoot",
          value: function forRoot(configurationFactory) {
            return {
              ngModule: ApiModule,
              providers: [{
                provide: _configuration__WEBPACK_IMPORTED_MODULE_1__["Configuration"],
                useFactory: configurationFactory
              }]
            };
          }
        }]);

        return ApiModule;
      }();

      ApiModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: ApiModule
      });
      ApiModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function ApiModule_Factory(t) {
          return new (t || ApiModule)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](ApiModule, 12), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"], 8));
        },
        providers: [],
        imports: [[]]
      });
      /*@__PURE__*/

      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ApiModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            imports: [],
            declarations: [],
            exports: [],
            providers: []
          }]
        }], function () {
          return [{
            type: ApiModule,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["SkipSelf"]
            }]
          }, {
            type: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"],
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
            }]
          }];
        }, null);
      })();
      /***/

    },

    /***/
    "Sy1n":
    /*!**********************************!*\
      !*** ./src/app/app.component.ts ***!
      \**********************************/

    /*! exports provided: AppComponent */

    /***/
    function Sy1n(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "AppComponent", function () {
        return AppComponent;
      });
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var _generated__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! ./generated */
      "81EJ");
      /* harmony import */


      var _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! @angular/material/grid-list */
      "zkoq");
      /* harmony import */


      var _angular_material_table__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! @angular/material/table */
      "+0xr");
      /* harmony import */


      var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
      /*! @angular/material/form-field */
      "kmnG");
      /* harmony import */


      var _angular_material_input__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(
      /*! @angular/material/input */
      "qFsG");
      /* harmony import */


      var _angular_material_select__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(
      /*! @angular/material/select */
      "d3UM");
      /* harmony import */


      var _angular_material_core__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(
      /*! @angular/material/core */
      "FKr1");

      function AppComponent_th_4_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 12);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " ID ");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }

      function AppComponent_td_5_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 13);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }

        if (rf & 2) {
          var element_r6 = ctx.$implicit;

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r6.id, " ");
        }
      }

      function AppComponent_th_7_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 12);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " Name ");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }
      }

      function AppComponent_td_8_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 13);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }

        if (rf & 2) {
          var element_r7 = ctx.$implicit;

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r7.name, " ");
        }
      }

      function AppComponent_tr_9_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 14);
        }
      }

      function AppComponent_tr_10_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 15);
        }
      }

      var AppComponent = function AppComponent(softwareService) {
        var _this4 = this;

        _classCallCheck(this, AppComponent);

        this.softwareService = softwareService;
        this.title = 'client';
        this.displayedColumns = ['id', 'name'];
        this.dataSource = [];
        this.softwareService.getCustomers().subscribe(function (x) {
          return _this4.dataSource = x;
        }, function (err) {
          return console.error('Observer got an error: ' + err);
        }, function () {
          return console.error('Observer finished');
        });
      };

      AppComponent.ɵfac = function AppComponent_Factory(t) {
        return new (t || AppComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_generated__WEBPACK_IMPORTED_MODULE_1__["CustomerService"]));
      };

      AppComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: AppComponent,
        selectors: [["app-root"]],
        decls: 29,
        vars: 3,
        consts: [["cols", "2"], ["mat-table", "", 1, "mat-elevation-z8", 3, "dataSource"], ["matColumnDef", "id"], ["mat-header-cell", "", 4, "matHeaderCellDef"], ["mat-cell", "", 4, "matCellDef"], ["matColumnDef", "name"], ["mat-header-row", "", 4, "matHeaderRowDef"], ["mat-row", "", 4, "matRowDef", "matRowDefColumns"], [1, "example-container"], ["appearance", "fill"], ["matInput", ""], ["value", "option"], ["mat-header-cell", ""], ["mat-cell", ""], ["mat-header-row", ""], ["mat-row", ""]],
        template: function AppComponent_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-grid-list", 0);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "mat-grid-tile");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "table", 1);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](3, 2);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](4, AppComponent_th_4_Template, 2, 0, "th", 3);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](5, AppComponent_td_5_Template, 2, 1, "td", 4);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](6, 5);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](7, AppComponent_th_7_Template, 2, 0, "th", 3);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](8, AppComponent_td_8_Template, 2, 1, "td", 4);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](9, AppComponent_tr_9_Template, 1, 0, "tr", 6);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](10, AppComponent_tr_10_Template, 1, 0, "tr", 7);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "mat-grid-tile");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "div", 8);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "mat-form-field", 9);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "mat-label");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](15, "Input");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](16, "input", 10);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](17, "br");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](18, "mat-form-field", 9);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](19, "mat-label");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](20, "Select");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](21, "mat-select");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](22, "mat-option", 11);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](23, "Option");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](24, "br");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](25, "mat-form-field", 9);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](26, "mat-label");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](27, "Textarea");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](28, "textarea", 10);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
          }

          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("dataSource", ctx.dataSource);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](7);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matHeaderRowDef", ctx.displayedColumns);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matRowDefColumns", ctx.displayedColumns);
          }
        },
        directives: [_angular_material_grid_list__WEBPACK_IMPORTED_MODULE_2__["MatGridList"], _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_2__["MatGridTile"], _angular_material_table__WEBPACK_IMPORTED_MODULE_3__["MatTable"], _angular_material_table__WEBPACK_IMPORTED_MODULE_3__["MatColumnDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_3__["MatHeaderCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_3__["MatCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_3__["MatHeaderRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_3__["MatRowDef"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_4__["MatFormField"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_4__["MatLabel"], _angular_material_input__WEBPACK_IMPORTED_MODULE_5__["MatInput"], _angular_material_select__WEBPACK_IMPORTED_MODULE_6__["MatSelect"], _angular_material_core__WEBPACK_IMPORTED_MODULE_7__["MatOption"], _angular_material_table__WEBPACK_IMPORTED_MODULE_3__["MatHeaderCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_3__["MatCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_3__["MatHeaderRow"], _angular_material_table__WEBPACK_IMPORTED_MODULE_3__["MatRow"]],
        styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJhcHAuY29tcG9uZW50LmNzcyJ9 */"]
      });
      /*@__PURE__*/

      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](AppComponent, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'app-root',
            templateUrl: './app.component.html',
            styleUrls: ['./app.component.css']
          }]
        }], function () {
          return [{
            type: _generated__WEBPACK_IMPORTED_MODULE_1__["CustomerService"]
          }];
        }, null);
      })();
      /***/

    },

    /***/
    "Ut8J":
    /*!*********************************************!*\
      !*** ./src/app/generated/model/phoneDTO.ts ***!
      \*********************************************/

    /*! no exports provided */

    /***/
    function Ut8J(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /**
       * customer api
       * API of service example customer
       *
       * The version of the OpenAPI document: 1.0.0
       *
       *
       * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
       * https://openapi-generator.tech
       * Do not edit the class manually.
       */

      /***/

    },

    /***/
    "VfPu":
    /*!***********************************************!*\
      !*** ./src/app/generated/model/addressDTO.ts ***!
      \***********************************************/

    /*! no exports provided */

    /***/
    function VfPu(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /**
       * customer api
       * API of service example customer
       *
       * The version of the OpenAPI document: 1.0.0
       *
       *
       * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
       * https://openapi-generator.tech
       * Do not edit the class manually.
       */

      /***/

    },

    /***/
    "ZAI4":
    /*!*******************************!*\
      !*** ./src/app/app.module.ts ***!
      \*******************************/

    /*! exports provided: AppModule */

    /***/
    function ZAI4(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "AppModule", function () {
        return AppModule;
      });
      /* harmony import */


      var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/platform-browser */
      "jhN1");
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var _app_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! ./app-routing.module */
      "vY5A");
      /* harmony import */


      var _app_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! ./app.component */
      "Sy1n");
      /* harmony import */


      var _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
      /*! @angular/platform-browser/animations */
      "R1ws");
      /* harmony import */


      var _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(
      /*! @angular/material/grid-list */
      "zkoq");
      /* harmony import */


      var _angular_material_table__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(
      /*! @angular/material/table */
      "+0xr");
      /* harmony import */


      var _angular_material_input__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(
      /*! @angular/material/input */
      "qFsG");
      /* harmony import */


      var _environments_environment__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(
      /*! ../environments/environment */
      "AytR");
      /* harmony import */


      var _angular_common_http__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(
      /*! @angular/common/http */
      "tk/3");
      /* harmony import */


      var _angular_material_core__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(
      /*! @angular/material/core */
      "FKr1");
      /* harmony import */


      var _angular_material_select__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(
      /*! @angular/material/select */
      "d3UM");
      /* harmony import */


      var _generated__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(
      /*! ./generated */
      "81EJ");

      var AppModule = function AppModule() {
        _classCallCheck(this, AppModule);
      };

      AppModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdefineNgModule"]({
        type: AppModule,
        bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]]
      });
      AppModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdefineInjector"]({
        factory: function AppModule_Factory(t) {
          return new (t || AppModule)();
        },
        providers: [{
          provide: _generated__WEBPACK_IMPORTED_MODULE_12__["BASE_PATH"],
          useValue: _environments_environment__WEBPACK_IMPORTED_MODULE_8__["environment"].API_BASE_PATH
        }],
        imports: [[_angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"], _app_routing_module__WEBPACK_IMPORTED_MODULE_2__["AppRoutingModule"], _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_4__["NoopAnimationsModule"], _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_5__["MatGridListModule"], _angular_material_table__WEBPACK_IMPORTED_MODULE_6__["MatTableModule"], _angular_material_input__WEBPACK_IMPORTED_MODULE_7__["MatInputModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_10__["MatOptionModule"], _angular_material_select__WEBPACK_IMPORTED_MODULE_11__["MatSelectModule"], _angular_common_http__WEBPACK_IMPORTED_MODULE_9__["HttpClientModule"]]]
      });

      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵsetNgModuleScope"](AppModule, {
          declarations: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]],
          imports: [_angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"], _app_routing_module__WEBPACK_IMPORTED_MODULE_2__["AppRoutingModule"], _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_4__["NoopAnimationsModule"], _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_5__["MatGridListModule"], _angular_material_table__WEBPACK_IMPORTED_MODULE_6__["MatTableModule"], _angular_material_input__WEBPACK_IMPORTED_MODULE_7__["MatInputModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_10__["MatOptionModule"], _angular_material_select__WEBPACK_IMPORTED_MODULE_11__["MatSelectModule"], _angular_common_http__WEBPACK_IMPORTED_MODULE_9__["HttpClientModule"]]
        });
      })();
      /*@__PURE__*/


      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵsetClassMetadata"](AppModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"],
          args: [{
            declarations: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]],
            imports: [_angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"], _app_routing_module__WEBPACK_IMPORTED_MODULE_2__["AppRoutingModule"], _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_4__["NoopAnimationsModule"], _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_5__["MatGridListModule"], _angular_material_table__WEBPACK_IMPORTED_MODULE_6__["MatTableModule"], _angular_material_input__WEBPACK_IMPORTED_MODULE_7__["MatInputModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_10__["MatOptionModule"], _angular_material_select__WEBPACK_IMPORTED_MODULE_11__["MatSelectModule"], _angular_common_http__WEBPACK_IMPORTED_MODULE_9__["HttpClientModule"]],
            providers: [{
              provide: _generated__WEBPACK_IMPORTED_MODULE_12__["BASE_PATH"],
              useValue: _environments_environment__WEBPACK_IMPORTED_MODULE_8__["environment"].API_BASE_PATH
            }],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]]
          }]
        }], null, null);
      })();
      /***/

    },

    /***/
    "jTWb":
    /*!**************************************!*\
      !*** ./src/app/generated/encoder.ts ***!
      \**************************************/

    /*! exports provided: CustomHttpParameterCodec */

    /***/
    function jTWb(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "CustomHttpParameterCodec", function () {
        return CustomHttpParameterCodec;
      });
      /**
       * Custom HttpParameterCodec
       * Workaround for https://github.com/angular/angular/issues/18261
       */


      var CustomHttpParameterCodec = /*#__PURE__*/function () {
        function CustomHttpParameterCodec() {
          _classCallCheck(this, CustomHttpParameterCodec);
        }

        _createClass(CustomHttpParameterCodec, [{
          key: "encodeKey",
          value: function encodeKey(k) {
            return encodeURIComponent(k);
          }
        }, {
          key: "encodeValue",
          value: function encodeValue(v) {
            return encodeURIComponent(v);
          }
        }, {
          key: "decodeKey",
          value: function decodeKey(k) {
            return decodeURIComponent(k);
          }
        }, {
          key: "decodeValue",
          value: function decodeValue(v) {
            return decodeURIComponent(v);
          }
        }]);

        return CustomHttpParameterCodec;
      }();
      /***/

    },

    /***/
    "khgH":
    /*!************************************************!*\
      !*** ./src/app/generated/model/customerDTO.ts ***!
      \************************************************/

    /*! no exports provided */

    /***/
    function khgH(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /***/

    },

    /***/
    "u36I":
    /*!*******************************************!*\
      !*** ./src/app/generated/model/models.ts ***!
      \*******************************************/

    /*! no exports provided */

    /***/
    function u36I(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony import */


      var _addressDTO__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! ./addressDTO */
      "VfPu");
      /* empty/unused harmony star reexport */

      /* harmony import */


      var _customerDTO__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! ./customerDTO */
      "khgH");
      /* empty/unused harmony star reexport */

      /* harmony import */


      var _phoneDTO__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! ./phoneDTO */
      "Ut8J");
      /* empty/unused harmony star reexport */

      /***/

    },

    /***/
    "vSC0":
    /*!****************************************!*\
      !*** ./src/app/generated/variables.ts ***!
      \****************************************/

    /*! exports provided: BASE_PATH, COLLECTION_FORMATS */

    /***/
    function vSC0(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "BASE_PATH", function () {
        return BASE_PATH;
      });
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "COLLECTION_FORMATS", function () {
        return COLLECTION_FORMATS;
      });
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");

      var BASE_PATH = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["InjectionToken"]('basePath');
      var COLLECTION_FORMATS = {
        'csv': ',',
        'tsv': '   ',
        'ssv': ' ',
        'pipes': '|'
      };
      /***/
    },

    /***/
    "vY5A":
    /*!***************************************!*\
      !*** ./src/app/app-routing.module.ts ***!
      \***************************************/

    /*! exports provided: AppRoutingModule */

    /***/
    function vY5A(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function () {
        return AppRoutingModule;
      });
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! @angular/router */
      "tyNb");

      var routes = [];

      var AppRoutingModule = function AppRoutingModule() {
        _classCallCheck(this, AppRoutingModule);
      };

      AppRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: AppRoutingModule
      });
      AppRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function AppRoutingModule_Factory(t) {
          return new (t || AppRoutingModule)();
        },
        imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forRoot(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
      });

      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](AppRoutingModule, {
          imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]],
          exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        });
      })();
      /*@__PURE__*/


      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](AppRoutingModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forRoot(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
          }]
        }], null, null);
      })();
      /***/

    },

    /***/
    "zUnb":
    /*!*********************!*\
      !*** ./src/main.ts ***!
      \*********************/

    /*! no exports provided */

    /***/
    function zUnb(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var _environments_environment__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! ./environments/environment */
      "AytR");
      /* harmony import */


      var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! ./app/app.module */
      "ZAI4");
      /* harmony import */


      var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! @angular/platform-browser */
      "jhN1");

      if (_environments_environment__WEBPACK_IMPORTED_MODULE_1__["environment"].production) {
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
      }

      _angular_platform_browser__WEBPACK_IMPORTED_MODULE_3__["platformBrowser"]().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])["catch"](function (err) {
        return console.error(err);
      });
      /***/

    },

    /***/
    "zn8P":
    /*!******************************************************!*\
      !*** ./$$_lazy_route_resource lazy namespace object ***!
      \******************************************************/

    /*! no static exports found */

    /***/
    function zn8P(module, exports) {
      function webpackEmptyAsyncContext(req) {
        // Here Promise.resolve().then() is used instead of new Promise() to prevent
        // uncaught exception popping up in devtools
        return Promise.resolve().then(function () {
          var e = new Error("Cannot find module '" + req + "'");
          e.code = 'MODULE_NOT_FOUND';
          throw e;
        });
      }

      webpackEmptyAsyncContext.keys = function () {
        return [];
      };

      webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
      module.exports = webpackEmptyAsyncContext;
      webpackEmptyAsyncContext.id = "zn8P";
      /***/
    }
  }, [[0, "runtime", "vendor"]]]);
})();
//# sourceMappingURL=main-es5.js.map