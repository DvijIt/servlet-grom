package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.ItemController;
import entity.Item;

import java.io.*;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = "/test")
public class MyServlet extends HttpServlet {
    private final ItemController ITEM_CONTROLLER = new ItemController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println(ITEM_CONTROLLER.findById(Long.parseLong(req.getParameter("id"))));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            ObjectMapper objectMapper = new ObjectMapper();
            Item item = new Item();
            item = objectMapper.readValue(req.getInputStream(), item.getClass());
            item.setDateCreated(new Date());
            item.setLastUpdatedDate(new Date());
            resp.getWriter().println(ITEM_CONTROLLER.save(item));
//            resp.getWriter().println(item);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Item item = new Item();
        item = objectMapper.readValue(req.getInputStream(), item.getClass());
        Date dateCreated = ITEM_CONTROLLER.findById(item.getId()).get(0).getDateCreated();
        item.setDateCreated(dateCreated);
        item.setLastUpdatedDate(new Date());
        resp.getWriter().println(ITEM_CONTROLLER.update(item));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Item item = ITEM_CONTROLLER.findById(Long.parseLong(req.getParameter("id"))).get(0);
        ITEM_CONTROLLER.delete(item);
        resp.getWriter().println("Item with id = " + req.getParameter("id") + " was deleted");
    }
}