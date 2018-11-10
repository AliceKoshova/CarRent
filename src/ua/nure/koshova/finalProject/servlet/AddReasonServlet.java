package ua.nure.koshova.finalProject.servlet;

import org.apache.log4j.Logger;
import ua.nure.koshova.finalProject.service.OrderService;
import ua.nure.koshova.finalProject.servlet.constant.Pages;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/reason"})
public class AddReasonServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = Logger.getLogger(AddReasonServlet.class);

    private OrderService orderService = new OrderService();

    public AddReasonServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idOrderString = request.getParameter("idOrder");
        LOGGER.debug("Got idOrder parameter as " + idOrderString);
        Long numIdOrder = Long.valueOf(idOrderString);
        String reason = request.getParameter("comment");
        LOGGER.debug("Got reason for reject order parameter as " + reason);
        orderService.updateReason(numIdOrder,reason);
        response.sendRedirect("/ordersList");
    }
}