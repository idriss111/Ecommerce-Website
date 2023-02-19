		
		<div class="col-md-5 order-details">
						<div class="section-title text-center">
							<h3 class="title">Your Order</h3>
						</div>
						<div class="order-summary">
							<div class="order-col">
								<div><strong>PRODUCT</strong></div>
								<div><strong>TOTAL</strong></div>
							</div>
							<div class="order-products">
								<c:if test="${sessionScope.prods != null }">
									<c:forEach var="p" items="${sessionScope.prods}">
								<div class="order-col">
									<div>${p.qte} x ${p.nomProduit }</div>
									<div>${p.puProduit }</div>
								</div>
								</c:forEach>
								</c:if>
							</div>
							<div class="order-col">
								<div>Shiping</div>
								<div><strong>FREE</strong></div>
							</div>
							<div class="order-col">
								<div><strong>TOTAL</strong></div>
								<c:if test="${sessionScope.prods != null }">
											<c:set var="total" value="${0}"/>
										<c:forEach var="article" items="${sessionScope.prods}">
										    <c:set var="total" value="${total + article.puProduit * article.qte}" />
										</c:forEach>
										</c:if>
								<div><strong class="order-total">${total }MAD</strong></div>
							</div>
						</div>
						
						<div class="input-checkbox">
							<input type="checkbox" id="terms">
							<label for="terms">
								<span></span>
								I've read and accept the <a href="#">terms & conditions</a>
							</label>
						</div>
						
						<a href="${pageContext.request.contextPath}/commandeValide" class="primary-btn order-submit" type>Place order</a>
						
					</div>
					