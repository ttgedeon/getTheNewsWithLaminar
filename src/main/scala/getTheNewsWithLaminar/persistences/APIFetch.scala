package getTheNewsWithLaminar.persistences

import org.scalajs.dom
import scalajs.js.{undefined, Promise, UndefOr}
import scala.concurrent.ExecutionContext.Implicits.global
import org.scalajs.dom.{
  BodyInit,
  HeadersInit,
  HttpMethod,
  RequestCache,
  RequestInfo,
  RequestInit,
  RequestRedirect,
  Response
}

import scala.concurrent.Future

/**
 * This trait contains all the basic functionalities to implement 
 * API  calls
 */
trait APIFetch { this : CustomHeaders =>

  /**
    * Method for easy building of the request content
    * @param _method request method
    * @param _headers headers
    * @param _body body
    * @param _cache cache
    * @param _redirect redirect
    * @return org.scalajs.dom.RequestInit
    */
  def requestInit(
    _method: UndefOr[HttpMethod] = undefined,
    _headers: UndefOr[HeadersInit] = undefined,
    _body: UndefOr[BodyInit] = undefined,
    _cache: UndefOr[RequestCache] = undefined,
    _redirect: UndefOr[RequestRedirect] = undefined
  ): RequestInit =
    new RequestInit {
      method = _method
      headers = _headers
      body = _body
      cache = _cache
      redirect = _redirect
    }

  /**
    * Actual
    * @param info Information on the request,like URL
    * @param requestInit content of the request, like body, method, header...
    * @return Future[Response]
    */
  def customFetch(info: RequestInfo,
                  requestInit: RequestInit): Future[Response] =
    dom
      .fetch(info = info, init = requestInit)
      .toFuture

  /**
   * Performs the API call and returns an asynchronous response
   * @param _url request URL
   * @param _headers request headers
   * @param _method request method
   * @param _body request body
   * @return Future[Response]
   */
  def launchFetch(_url: String, _headers: Map[String, String], _method: HttpMethod,
                  _body: BodyInit): Future[Response] =
    import org.scalajs.dom.Headers
    val headings: Headers =
      if _headers.isEmpty then initialHeaders else computeHeaders(_headers)

    val requestInitial: RequestInit = requestInit(
      _method = _method,
      _headers = headings,
      _body = _body,
    )
    customFetch(info = _url, requestInit = requestInitial)
  end launchFetch

  /**
   * Performs an API POST method call and returns an asynchronous response
   * @param _url request URL
   * @param _body request body
   * @param _headers request additional headers
   * @return Future[Response]
   */
  def post(_url: String, _body: BodyInit, _headers: Map[String, String]): Future[Response] =
    launchFetch(_url = _url, _headers = _headers, _method = HttpMethod.POST, _body = _body)
  end post

  /**
   * Performs an API `GET` method call and returns an asynchronous response
   * @param _url request URL
   * @param _body request body
   * @param _headers request additional headers
   * @return Future[Response]
   */
  def get(_url: String, _body: BodyInit, _headers: Map[String, String]): Future[Response] =
    launchFetch(_url = _url, _headers = _headers, _method = HttpMethod.GET, _body = _body)
  end get

  /**
   * Performs an API `PATCH` method call and returns an asynchronous response
   * @param _url request URL
   * @param _body request body
   * @param _headers request additional headers
   * @return Future[Response]
   */
  def patch(_url: String, _body: BodyInit, _headers: Map[String, String]): Future[Response] =
    launchFetch(_url = _url, _headers = _headers, _method = HttpMethod.PATCH, _body = _body)
  end patch

  /**
   * Performs an API `PUT` method call and returns an asynchronous response
   * @param _url request URL
   * @param _body request body
   * @param _headers request additional headers
   * @return Future[Response]
   */
  def put(_url: String, _body: BodyInit, _headers: Map[String, String]): Future[Response] =
    launchFetch(_url = _url, _headers = _headers, _method = HttpMethod.PUT, _body = _body)
  end put

  /**
   * Performs an API `DELETE` method call and returns an asynchronous response
   * @param _url request URL
   * @param _body request body
   * @param _headers request additional headers
   * @return Future[Response]
   */
  def delete(_url: String, _body: BodyInit, _headers: Map[String, String]): Future[Response] =
    launchFetch(_url = _url, _headers = _headers, _method = HttpMethod.DELETE, _body = _body)
  end delete

  /**
   * Performs an API `HEAD` method call and returns an asynchronous response
   * @param _url request URL
   * @param _body request body
   * @param _headers request additional headers
   * @return Future[Response]
   */
  def getHeads(_url: String, _body: BodyInit, _headers: Map[String, String]): Future[Response] =
    launchFetch(_url = _url, _headers = _headers, _method = HttpMethod.HEAD, _body = _body)
  end getHeads


  /**
   * Performs an API `OPTIONS` method call and returns an asynchronous response
   * @param _url request URL
   * @param _body request body
   * @param _headers request additional headers
   * @return Future[Response]
   */
  def getOptions(_url: String, _body: BodyInit, _headers: Map[String, String]): Future[Response] =
    launchFetch(_url = _url, _headers = _headers, _method = HttpMethod.OPTIONS, _body = _body)
  end getOptions
}
