/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.avinash.phonecat;

import com.avinash.phonecat.model.PhoneCatService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.util.ReleaseInfo;

import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import net.securus.wccs.domain.Transaction;
import net.securus.wccs.services.TransactionService;

@Controller
@RequestMapping("VIEW")
public class PortletViewController {

    private static final Logger LOG = LoggerFactory.getLogger(PortletViewController.class);
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    @Autowired
    PhoneCatService phoneCatService;
    @Autowired
    TransactionService transactionService;

	@RenderMapping
    public String question(RenderRequest request, RenderResponse response, Model model) {
		model.addAttribute("releaseInfo", ReleaseInfo.getReleaseInfo());
        ResourceURL baseResourceUrl = response.createResourceURL();
        model.addAttribute("ajaxURL", baseResourceUrl.toString());
        model.addAttribute("standalone", false);
        model.addAttribute("portletAppContextPath", request.getContextPath() + "/");

		return "liferay-angular-phonecat/index";
	}


    @ResourceMapping("testList")
    public void userList(@RequestParam long accountId, @RequestParam String accountType,
            ResourceResponse response) throws Exception {
        LOG.debug("Got list of transactions for account : ", accountId);
        List<Transaction> transactions = this.transactionService.getTransactions(accountId,
                accountType);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JSON_MAPPER.writeValue(response.getPortletOutputStream(), transactions);
    }

}
